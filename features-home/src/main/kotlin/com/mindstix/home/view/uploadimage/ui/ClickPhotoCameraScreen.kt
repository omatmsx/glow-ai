package com.mindstix.home.view.uploadimage.ui

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.capabilities.presentation.theme.textStyle2
import com.mindstix.core.R
import com.mindstix.home.intent.ClickPictureScreenState
import com.mindstix.home.intent.ClickPictureScreenViewStates

@Composable
fun FaceDetectionUI(
    onGalleryClick: () -> Unit,
    onCameraClick: () -> Unit,
    onContinueClick: () -> Unit,
    faceImagePainter: Uri, // This painter will load the image or illustration
    state: ClickPictureScreenState
) {
    val galleryText = "Gallery"
    val cameraText = "Camera"
    val continueText = "Continue"
    val headerText = "Provide a clear picture of your face"
    val headerDesc1 = "Without Glasses"
    val headerDesc2 = "Without makeup"
    val headerDesc3 = "In Natural light"
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.image_scanning))



    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween,

        modifier = Modifier
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize()
    ) {

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {


            Text(
                text = headerText, color = Color.Black, style = textStyle1.copy(
                    fontSize = 24.sp
                )
            )
            Text(
                text = headerDesc1,
                color = Color(0xFF625B71),
                style = textStyle1.copy(
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = headerDesc2, color = Color(0xFF625B71), style = textStyle1.copy(
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                text = headerDesc3, color = Color(0xFF625B71), style = textStyle1.copy(
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(top = 5.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .height(300.dp).fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(250.dp)
                        .clip(CircleShape)
                        .border(
                            width = 4.dp, // Width of the border
                            brush = SolidColor(Color.LightGray), // Border color
                            shape = CircleShape
                        )
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center,
                ) {
                    if (faceImagePainter.path?.isNotEmpty() == true) {
                        Image(
                            painter = rememberImagePainter(data = faceImagePainter),
                            contentDescription = "Face Detection Area",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(230.dp)
                        )
                    } else {
                        Image(
                            modifier = Modifier.clip(RoundedCornerShape(30.dp)),
                            painter = painterResource(id = R.drawable.ic_image),
                            contentDescription = null
                        )
                    }
                }


                if (state.ageScreenViewState is ClickPictureScreenViewStates.InitialLoading) {
                    val loadingState =
                        state.ageScreenViewState as ClickPictureScreenViewStates.InitialLoading
                    if (loadingState.showLoader) {
                        LottieAnimation(
                            composition = composition,
                            iterations = LottieConstants.IterateForever, // Loop the animation indefinitely
                            modifier = Modifier.size(300.dp)
                        )
                    }
                }
            }

            if (state.ageScreenViewState is ClickPictureScreenViewStates.InitialLoading) {
                val loadingState =
                    state.ageScreenViewState as ClickPictureScreenViewStates.InitialLoading
                if (loadingState.showLoader) {
                    Text(
                        text = loadingState.message,
                        modifier = Modifier
                            .fillMaxWidth() // Make the Text full width
                            .padding(horizontal = 16.dp), // Optional padding for better appearance
                        textAlign = TextAlign.Center // Center the text
                    )
                }
            }
        }

        Column(
            modifier = Modifier.padding(vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Circular Face detection area

            // Gallery and Camera Buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onGalleryClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEAE6F8))
                ) {
                    Text(
                        text = galleryText, color = Color(0xFF625B71), style = textStyle1.copy(
                            fontSize = 16.sp
                        )
                    )
                }

                Button(
                    onClick = onCameraClick,
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF655585))
                ) {
                    Text(
                        text = cameraText, color = Color.White, style = textStyle1.copy(
                            fontSize = 16.sp
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Continue Button
            Button(
                onClick = { onContinueClick.invoke() },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE8DEF8)),
                enabled = faceImagePainter.path?.isNotEmpty() == true
            ) {
                Text(
                    text = continueText, color = Color(0xFF625B71), style = textStyle1.copy(
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}
