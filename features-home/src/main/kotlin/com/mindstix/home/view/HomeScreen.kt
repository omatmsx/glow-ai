/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.home.view

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.database.entities.RecommendedMakeupProductEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.capabilities.presentation.theme.textStyle2
import com.mindstix.capabilities.util.Constants.DEFAULT_BEAUTY_LIST_URLS
import com.mindstix.capabilities.util.Constants.DEFAULT_LIST_URLS
import com.mindstix.home.intent.HomeScreenIntent
import com.mindstix.home.view.dashboard.modal.SkinAnalysisEntityDataModal
import com.mindstix.home.view.dashboard.ui.DiagnosisList
import com.mindstix.home.view.dashboard.ui.RecommendedMakeUpProductsUI
import com.mindstix.home.view.dashboard.ui.RecommendedProductsUI
import com.mindstix.home.view.dashboard.ui.SkinAnalysisUI
import com.mindstix.home.viewmodel.HomeScreenViewModel
import com.mindstix.onboarding.utils.NotificationHelper

/**
 * Composable function representing the Home Screen.
 */
@SuppressLint("Recycle", "MissingPermission")
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel, userIntent: (HomeScreenIntent) -> Unit
) {
    val skinAnalyses by homeScreenViewModel.skinAnalysesState
    val weatherData by homeScreenViewModel.weatherData
    // Map the values into a list of specific fields
    val mappedSkinAnalyses = skinAnalyses.map { analysis ->
        SkinAnalysisEntityDataModal(
            poresLeftCheekConfidence = analysis.poresLeftCheekConfidence,
            poresLeftCheekValue = analysis.poresLeftCheekValue,
            eyePouchConfidence = analysis.eyePouchConfidence,
            eyePouchValue = analysis.eyePouchValue,
            foreheadWrinkleConfidence = analysis.foreheadWrinkleConfidence,
            foreheadWrinkleValue = analysis.foreheadWrinkleValue,
            skinSpotConfidence = analysis.skinSpotConfidence,
            skinSpotValue = analysis.skinSpotValue,
            acneConfidence = analysis.acneConfidence,
            acneValue = analysis.acneValue,
            poresForeheadConfidence = analysis.poresForeheadConfidence,
            poresForeheadValue = analysis.poresForeheadValue,
            eyeFinelinesConfidence = analysis.eyeFinelinesConfidence,
            eyeFinelinesValue = analysis.eyeFinelinesValue,
            darkCircleConfidence = analysis.darkCircleConfidence,
            darkCircleValue = analysis.darkCircleValue,
            poresRightCheekConfidence = analysis.poresRightCheekConfidence,
            poresRightCheekValue = analysis.poresRightCheekValue,
            blackheadConfidence = analysis.blackheadConfidence,
            blackheadValue = analysis.blackheadValue,
            skinType = analysis.skinType,
            nasolabialFoldConfidence = analysis.nasolabialFoldConfidence,
            nasolabialFoldValue = analysis.nasolabialFoldValue,
            poresJawConfidence = analysis.poresJawConfidence,
            poresJawValue = analysis.poresJawValue,
            leftEyelidsConfidence = analysis.leftEyelidsConfidence,
            leftEyelidsValue = analysis.leftEyelidsValue,
            crowsFeetConfidence = analysis.crowsFeetConfidence,
            crowsFeetValue = analysis.crowsFeetValue,
            glabellaWrinkleConfidence = analysis.glabellaWrinkleConfidence,
            glabellaWrinkleValue = analysis.glabellaWrinkleValue,
            moleConfidence = analysis.moleConfidence,
            moleValue = analysis.moleValue,
            rightEyelidsConfidence = analysis.rightEyelidsConfidence,
            rightEyelidsValue = analysis.rightEyelidsValue
        )
    }

    val recommendedProduct by homeScreenViewModel.skinRecommendedProduct
    val currentIndex = remember { mutableStateOf(0) }
    val buyNowUrls = DEFAULT_LIST_URLS
    val buyNowBeautyUrls = DEFAULT_BEAUTY_LIST_URLS

    val randomUrl = remember {
        buyNowUrls[currentIndex.value].also {
            // Increment the index, and reset to 0 if we reach the end of the list
            currentIndex.value = (currentIndex.value + 1) % buyNowUrls.size
        }
    }
    val randomBeautyUrl = remember {
        buyNowBeautyUrls[currentIndex.value].also {
            // Increment the index, and reset to 0 if we reach the end of the list
            currentIndex.value = (currentIndex.value + 1) % buyNowBeautyUrls.size
        }
    }
    val recommendedMakeupProduct by homeScreenViewModel.recommendedMakeupProduct

    LaunchedEffect(true) {
        userIntent.invoke(
            HomeScreenIntent.GetSkinAnalysisData
        )
        userIntent.invoke(
            HomeScreenIntent.GetRecommendedProducts
        )
        userIntent.invoke(
            HomeScreenIntent.GetRecommendedMakeupProduct
        )
        userIntent.invoke(
            HomeScreenIntent.GetWeatherData
        )
    }

    if (weatherData.isNotEmpty()) {
        NotificationHelper(LocalContext.current).sendNotification(weatherData)
    }


    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<SkincareProductEntity?>(null) }
    val context = LocalContext.current
    var selectedMakeUpItem by remember { mutableStateOf<RecommendedMakeupProductEntity?>(null) }

    if (showDialog && selectedItem != null) {
        // Display the dialog
        Box(
            modifier = Modifier.fillMaxSize(), // Fills the entire available space
            contentAlignment = Alignment.Center
        ) // Centers the content within the Box
        {
            AlertDialog(modifier = Modifier
                .padding(horizontal = 20.dp)
                .wrapContentSize(),
                containerColor = Color.White,
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "Item Details", color = Color(0xFF2E1A47), style = textStyle1.copy(
                            fontSize = 18.sp, fontWeight = FontWeight.Medium
                        ), lineHeight = 16.sp, modifier = Modifier.padding(top = 5.dp)
                    )
                },
                text = {
                    // You can access the selected item's properties here
                    Column {
                        Text(
                            text = "What it contains",
                            color = Color(0xFF493266),
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 16.sp
                            ),
                            lineHeight = 16.sp,
                        )
                        Text(
                            text = "* ${selectedItem?.whatItContains}",
                            color = Color.Gray,
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 14.sp
                            ),
                            lineHeight = 14.sp,
                        )

                        Text(
                            text = "Why you should use this",
                            color = Color(0xFF493266),
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 16.sp
                            ),
                            lineHeight = 16.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            text = "* ${selectedItem?.whyWeShouldDoIt}",
                            color = Color.Gray,
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 14.sp
                            ),
                            lineHeight = 14.sp,
                        )
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(
                            text = "OK", color = Color(0xFF2E1A47), style = textStyle2.copy(
                                fontSize = 14.sp
                            ), lineHeight = 14.sp, modifier = Modifier.padding(end = 50.dp)
                        )
                    }
                },
                confirmButton = {
                    FilledTonalButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(randomUrl))
                            try {
                                context.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                // log error or take some other action, but it would be very rare for a
                                // device to have no browser installed
                            }

                        }, modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Buy Now", color = Color(0xFF2E1A47), style = textStyle2.copy(
                                fontSize = 14.sp
                            ), lineHeight = 14.sp
                        )
                    }
                })
        }
    }
    if (showDialog && selectedMakeUpItem != null) {
        // Display the dialog
        Box(
            modifier = Modifier.fillMaxSize(), // Fills the entire available space
            contentAlignment = Alignment.Center
        ) // Centers the content within the Box
        {
            AlertDialog(modifier = Modifier
                .padding(horizontal = 20.dp)
                .wrapContentSize(),
                containerColor = Color.White,
                onDismissRequest = { showDialog = false },
                title = {
                    Text(
                        text = "Item Details", color = Color(0xFF2E1A47), style = textStyle1.copy(
                            fontSize = 18.sp, fontWeight = FontWeight.Medium
                        ), lineHeight = 16.sp, modifier = Modifier.padding(top = 5.dp)
                    )
                },
                text = {
                    // You can access the selected item's properties here
                    Column {
                        Text(
                            text = "What it contains",
                            color = Color(0xFF493266),
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 16.sp
                            ),
                            lineHeight = 16.sp,
                        )
                        Text(
                            text = "* ${selectedMakeUpItem?.whatItContains}",
                            color = Color.Gray,
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 14.sp
                            ),
                            lineHeight = 14.sp,
                        )

                        Text(
                            text = "Why you should use this",
                            color = Color(0xFF493266),
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 16.sp
                            ),
                            lineHeight = 16.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                        Text(
                            text = "* ${selectedMakeUpItem?.whyWeShouldDoIt}",
                            color = Color.Gray,
                            maxLines = 3,
                            style = textStyle1.copy(
                                fontSize = 14.sp
                            ),
                            lineHeight = 14.sp,
                        )
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(
                            text = "OK", color = Color(0xFF2E1A47), style = textStyle2.copy(
                                fontSize = 14.sp
                            ), lineHeight = 14.sp, modifier = Modifier.padding(end = 50.dp)
                        )
                    }
                },
                confirmButton = {
                    FilledTonalButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(randomBeautyUrl))
                            try {
                                context.startActivity(intent)
                            } catch (e: ActivityNotFoundException) {
                                // log error or take some other action, but it would be very rare for a
                                // device to have no browser installed
                            }

                        }, modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Buy Now", color = Color(0xFF2E1A47), style = textStyle2.copy(
                                fontSize = 14.sp
                            ), lineHeight = 14.sp
                        )
                    }
                })
        }
    }

    LazyColumn(
        verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxHeight()
    ) {
        item {
            SkinAnalysisUI()
        }

        item {
            DiagnosisList(items = mappedSkinAnalyses) {}
        }
        item {
            RecommendedProductsUI(recommendedProduct) {
                selectedItem = it
                showDialog = true
            }
        }
        item {
            RecommendedMakeUpProductsUI(recommendedMakeupProduct) {
                selectedMakeUpItem = it
                showDialog = true
            }
        }
        item {
//            SkinCareRoutineUI()
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}


