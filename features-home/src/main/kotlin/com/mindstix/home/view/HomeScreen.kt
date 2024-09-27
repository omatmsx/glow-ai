/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.home.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.capabilities.presentation.theme.textStyle1
import com.mindstix.capabilities.presentation.theme.textStyle2
import com.mindstix.home.intent.HomeScreenIntent
import com.mindstix.home.view.dashboard.modal.SkinAnalysisEntityDataModal
import com.mindstix.home.view.dashboard.ui.DiagnosisList
import com.mindstix.home.view.dashboard.ui.RecommendedProductsUI
import com.mindstix.home.view.dashboard.ui.SkinAnalysisUI
import com.mindstix.home.viewmodel.HomeScreenViewModel

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

    LaunchedEffect(true) {
        userIntent.invoke(
            HomeScreenIntent.GetSkinAnalysisData
        )
        userIntent.invoke(
            HomeScreenIntent.GetRecommendedProducts
        )
    }


// State to track the dialog visibility and selected item
    var showDialog by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<SkincareProductEntity?>(null) }

// Show dialog if showDialog is true
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
                        text = "Item Details", color = Color.Black, style = textStyle2.copy(
                            fontSize = 16.sp
                        ), lineHeight = 16.sp, modifier = Modifier.padding(top = 5.dp)
                    )
                },
                text = {
                    // You can access the selected item's properties here
                    Column {
                        Text(
                            text = "What it contains",
                            color = Color.Black,
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
                            text = "Why to use this",
                            color = Color.Black,
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
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text(
                            text = "OK", color = Color.Black, style = textStyle2.copy(
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
            TextButton(
                onClick = {
                    userIntent.invoke(
                        HomeScreenIntent.GetWeatherData
                    )
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = weatherData.ifEmpty { "Weather" }, modifier = Modifier.fillMaxWidth()
                )
            }
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
//            SkinCareRoutineUI()
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}


