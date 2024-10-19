/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.home.view

import android.content.ActivityNotFoundException
import android.content.Intent
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.capabilities.presentation.theme.textStyle2
import com.mindstix.capabilities.util.Constants
import com.mindstix.core.R
import com.mindstix.home.intent.SkinCareRoutineScreenIntent
import com.mindstix.home.intent.SkinCareRoutineScreenViewStates
import com.mindstix.home.view.skinroutine.modal.SkinCareRoutineDataClass
import com.mindstix.home.viewmodel.SkinCareRoutineScreenViewModel

@Composable
fun SkinCareRoutineScreen(
    skinCareRoutineScreenViewModel: SkinCareRoutineScreenViewModel,
    state: SkinCareRoutineScreenViewStates.LoadedData,
    userIntent: (SkinCareRoutineScreenIntent) -> Unit
) {

    val skinCareRoutineList = state.data.skinCareRoutineList

    val list = skinCareRoutineList.map {
        val icon = if (it.time == "morning") {
            R.drawable.ic_skin_care
        } else {
            R.drawable.ic_skin_evening

        }
        SkinCareRoutineDataClass(
            title = it.task,
            description = it.whyWeShouldDoIt,
            iconRes = icon,
            time = it.time,
            produtName = it.productName
        )
    }

    val morningTask = list.filter { it.time == "morning" }
    val eveningTask = list.filter { it.time == "evening" }
    val currentIndex = remember { mutableStateOf(0) }
    val productImgList = Constants.DEFAULT_PRODUCT_IMAGE
    val productUrlList = Constants.DEFAULT_LIST_URLS

    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Header Title
        Text(
            text = "Personalized Skin Care Routine",
            modifier = Modifier.padding(bottom = 16.dp),
            style = textStyle1.copy(
                fontSize = 24.sp
            ),
            color = Color(0xFF493266),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            item {
                Text(
                    text = "Morning Routine", style = textStyle1.copy(
                        fontSize = 20.sp
                    ), color = Color(0xFF493266)
                )
            }

            items(morningTask) { routine ->
                val randomImage = remember {
                    productImgList[currentIndex.value].also {
                        // Increment the index, and reset it to 0 if we reach the end of the list
                        currentIndex.value = (currentIndex.value + 1) % productImgList.size
                    }
                }
                val randomUrl = remember {
                    productUrlList[currentIndex.value].also {
                        // Increment the index, and reset it to 0 if we reach the end of the list
                        currentIndex.value = (currentIndex.value + 1) % productUrlList.size
                    }
                }
                RoutineCard(routine = routine, randomImage, randomUrl)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "Evening Routine", style = textStyle1.copy(
                        fontSize = 20.sp
                    ), color = Color(0xFF493266)
                )
            }
            items(eveningTask) { routine ->
                val randomImage = remember {
                    productImgList[currentIndex.value].also {
                        // Increment the index, and reset it to 0 if we reach the end of the list
                        currentIndex.value = (currentIndex.value + 1) % productImgList.size
                    }
                }
                val randomUrl = remember {
                    productUrlList[currentIndex.value].also {
                        // Increment the index, and reset it to 0 if we reach the end of the list
                        currentIndex.value = (currentIndex.value + 1) % productUrlList.size
                    }
                }
                RoutineCard(routine = routine, randomImage, randomUrl)
            }
        }
    }
}

@Composable
fun RoutineCard(routine: SkinCareRoutineDataClass, productImgList: Int, randomUrl: String) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(0.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Left side: Product Info
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Icon on the left
                    Image(
                        painter = painterResource(id = routine.iconRes),
                        contentDescription = "Routine Icon",
                        modifier = Modifier
                            .size(30.dp)
                            .background(Color.Transparent, shape = CircleShape)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    // Title
                    Text(
                        text = routine.title,
                        style = textStyle1.copy(
                            fontSize = 16.sp, fontWeight = FontWeight.Medium
                        ),
                        lineHeight = 16.sp,
                        maxLines = 2,
                        color = Color(0xFF493266),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Description
                Text(
                    text = routine.description, color = Color.Gray, style = textStyle1.copy(
                        fontSize = 14.sp
                    ), lineHeight = 14.sp, maxLines = 3, modifier = Modifier.padding(start = 2.dp)
                )
            }

            // Right side: Product Card
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .height(150.dp)
                    .border(
                        width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.padding(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Product Image (replace with actual image resource)
                    Image(
                        painter = painterResource(id = productImgList), // Replace with actual image resource
                        contentDescription = "LBEL Defense Total",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    // Description
                    Text(
                        text = routine.produtName,
                        color = Color.Gray,
                        style = textStyle1.copy(
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,

                            ),
                        lineHeight = 12.sp,
                        maxLines = 2,
                        modifier = Modifier.padding(start = 2.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(randomUrl))
                            try {
                                context.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                // log error or take some other action, but it would be very rare for a
                                // device to have no browser installed
                            }
                        },
                        modifier = Modifier.height(28.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF493266)), // Custom button background color
                    ) {
                        Text(
                            text = "Buy", color = Color.White, style = textStyle2.copy(
                                fontSize = 12.sp
                            ), lineHeight = 12.sp
                        )
                    }
                }
            }
        }
    }
}
