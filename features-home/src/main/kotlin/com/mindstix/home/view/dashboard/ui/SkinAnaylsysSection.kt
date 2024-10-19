package com.mindstix.home.view.dashboard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.onboarding.utils.SharedPreferenceManager
import java.io.File

@Composable
fun SkinAnalysisUI() {

    val userPhoto = SharedPreferenceManager(LocalContext.current).userPhoto
    val painter = rememberImagePainter(data = File(userPhoto))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Title of the section
        Text(
            text = "Skin Analysis",
            style = textStyle1.copy(
                fontSize = 24.sp
            ),
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color(0xFF2E1A47)
        )

        // Image card for Skin Analysis
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color(0xFFDE9696), shape = RoundedCornerShape(16.dp))
        ) {
            // Main Image with rounded corners
            Image(
                painter = painter, // Replace with your image painter
                contentDescription = "Skin Analysis Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)) // Clip the image to a rounded corner
            )
        }
    }
}
