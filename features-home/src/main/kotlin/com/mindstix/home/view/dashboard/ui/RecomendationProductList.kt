package com.mindstix.home.view.dashboard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.core.R


@Composable
fun RecommendedProductsUI(recommendedProduct: List<SkincareProductEntity>) {
    val recommendedProductList = recommendedProduct
    val productImgList = listOf(
        R.drawable.ic_essikaproduct,
        R.drawable.ic_productimage,
        R.drawable.ic_vitaminc,
        R.drawable.ic_pillogram,
        R.drawable.ic_minimalist,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Title
        Text(
            text = "Recommended Products", fontSize = 20.sp, style = textStyle1.copy(
                fontSize = 20.sp
            ), modifier = Modifier.padding(bottom = 16.dp)
        )

        // Horizontal list of products
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Example of 4 items
            items(recommendedProductList) { item ->
                val randomImage = remember { productImgList.random() }
                ProductCard(
                    productName = item.productName, productImg = randomImage
                ) // Replace with your product image resource
                { /* Handle click */ }
            }
        }
    }
}

@Composable
fun ProductCard(productName: String, productImg: Int, onQuestionMarkClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(140.dp)
            .height(200.dp)
            .padding(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Product Image with question mark icon
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(data = productImg), // Replace with your product image
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(100.dp)
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .clip(shape = RoundedCornerShape(16.dp))
                )

                // Question mark icon on top-right of the image
                Icon(
                    painter = painterResource(id = R.drawable.ic_questionmark), // Replace with your question mark icon
                    contentDescription = "Info",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.TopEnd)
                )
            }

            Spacer(modifier = Modifier.weight(1F))

            // Product Name at the bottom
            Text(
                text = productName, color = Color.Black, maxLines = 3, style = textStyle1.copy(
                    fontSize = 16.sp
                ), lineHeight = 14.sp, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
