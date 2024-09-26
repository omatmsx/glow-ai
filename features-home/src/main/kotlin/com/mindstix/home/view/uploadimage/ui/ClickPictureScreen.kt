package com.mindstix.home.view.uploadimage.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.mindstix.home.intent.ClickPictureScreenIntent
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("Recycle")
@Composable
fun ClickPictureScreen(
    userIntent: (ClickPictureScreenIntent) -> Unit
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
                val tempFile = File(context.cacheDir,fileName )
                tempFile.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }

                userIntent.invoke(
                    ClickPictureScreenIntent.NavigateToAgeScreen(tempFile)
                )
            }
        },
        faceImagePainter = capturedImage,
    )
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