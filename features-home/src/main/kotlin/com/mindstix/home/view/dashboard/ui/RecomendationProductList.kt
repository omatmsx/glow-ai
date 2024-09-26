package com.mindstix.home.view.dashboard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.core.R


@Composable
fun RecommendedProductsUI() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Title
        Text(
            text = "Recommended Products",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Horizontal list of products
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Example of 4 items
            items(4) {
                ProductCard(
                    productName = "Cetaphil Skin cleaner",
                    imageRes = R.drawable.ic_image, // Replace with your product image resource
                    onQuestionMarkClick = { /* Handle click */ }
                )
            }
        }
    }
}

@Composable
fun ProductCard(productName: String, imageRes: Int, onQuestionMarkClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(120.dp)
            .height(160.dp)
            .padding(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Product Image with question mark icon
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_image_24), // Replace with your product image
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(100.dp)
                        .align(Alignment.TopCenter)
                        .clip(shape = RoundedCornerShape(16.dp))
                )

                // Question mark icon on top-right of the image
                Icon(
                    painter = painterResource(id = R.drawable.baseline_question_mark_24), // Replace with your question mark icon
                    contentDescription = "Info",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.TopEnd)
                )

            }

            // Product Name at the bottom
            Text(
                text = "Cetaphil Skin cleaner", // Replace with dynamic product name if needed
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                minLines = 2,
                lineHeight = 14.sp
            )
        }
    }
}
