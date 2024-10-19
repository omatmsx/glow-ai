package com.mindstix.home.view.uploadimage.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.mindstix.home.intent.ClickPictureScreenIntent
import com.mindstix.home.intent.ClickPictureScreenState
import com.mindstix.home.intent.ClickPictureScreenViewStates
import com.mindstix.onboarding.utils.SharedPreferenceManager
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("Recycle", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClickPictureScreen(
    userIntent: (ClickPictureScreenIntent) -> Unit,
    state: ClickPictureScreenState
) {
    val context = LocalContext.current

    val file = context.createImageFile()
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var uri = FileProvider.getUriForFile(
        context, "${context.packageName}.fileprovider", file
    )


    var capturedImage by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }
    // Set up the launcher for capturing the image
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        capturedImage = uri
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
                cameraLauncher.launch(uri)
            } else {
                Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }

    val snackbarHostState = remember { SnackbarHostState() }



    LaunchedEffect(state) {
        if (state.ageScreenViewState is ClickPictureScreenViewStates.ErrorState) {
            val errorState = state.ageScreenViewState as ClickPictureScreenViewStates.ErrorState
            snackbarHostState.showSnackbar(errorState.message)
        }
    }

    // ActivityResultLauncher to pick an image from the gallery
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            capturedImage = uri
        }

        // Load the selected image as Bitmap
        uri?.let {
            bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState) // Pass the SnackbarHostState to the SnackbarHost
        },
    ) { a ->

        FaceDetectionUI(
            onGalleryClick = {
                galleryLauncher.launch("image/*")
            },
            onCameraClick = {
                val permissionCheckResult =
                    ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {

                    cameraLauncher.launch(uri)
                } else {
                    permissionLauncher.launch(Manifest.permission.CAMERA)
                }
            },
            onContinueClick = {
                val contentResolver = context.contentResolver
                val fileName = getFileName(context, capturedImage)

                contentResolver.openInputStream(capturedImage)?.use { inputStream ->
                    // Create a temporary file from InputStream
                    val tempFile = File(context.cacheDir, fileName)
                    tempFile.outputStream().use { outputStream ->
                        inputStream.copyTo(outputStream)
                    }


                    val compressedFile = compressImageIfNeeded(tempFile, context)
                    SharedPreferenceManager(context).userPhoto = compressedFile.absolutePath

                    userIntent.invoke(
                        ClickPictureScreenIntent.NavigateToAgeScreen(compressedFile)
                    )
                }
            },
            faceImagePainter = capturedImage,
            state
        )
    }
}

fun Context.createImageFile(): File {
    // Create an image file name
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile(
        "JPEG_${timeStamp}_", /* prefix */
        ".jpg", /* suffix */
        storageDir /* directory */
    )
}

@SuppressLint("Range")
fun getFileName(context: Context, uri: Uri): String {
    var fileName = System.currentTimeMillis().toString()
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    cursor?.use {
        if (it.moveToFirst()) {
            fileName = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
        }
    }
    return fileName
}

private fun compressImageIfNeeded(file: File, context: Context): File {
    val maxSizeInBytes = 2 * 1024 * 1024 // 2 MB
    if (file.length() <= maxSizeInBytes) {
        return file // No compression needed
    }

    val bitmap = BitmapFactory.decodeFile(file.absolutePath)
    val outputStream = ByteArrayOutputStream()
    var quality = 100 // Start with high quality

    // Compress the image and reduce quality until it's under 2 MB
    do {
        outputStream.reset() // Clear the output stream
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
        quality -= 5 // Decrease quality
    } while (outputStream.size() > maxSizeInBytes && quality > 0)

    // Write the compressed image to a new file
    val compressedFile = File(context.cacheDir, "compressed_${file.name}.${file.extension}")
    FileOutputStream(compressedFile).use { fos ->
        fos.write(outputStream.toByteArray())
    }

    return compressedFile
}