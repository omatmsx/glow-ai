/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.home.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mindstix.home.intent.HomeScreenIntent
import com.mindstix.home.view.dashboard.modal.SkinAnalysisEntityDataModal
import com.mindstix.home.view.dashboard.ui.DiagnosisList
import com.mindstix.home.view.dashboard.ui.RecommendedProductsUI
import com.mindstix.home.view.dashboard.ui.SkinAnalysisUI
import com.mindstix.home.viewmodel.HomeScreenViewModel

/**
 * Composable function representing the Home Screen.
 */
@SuppressLint("Recycle")
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel, userIntent: (HomeScreenIntent) -> Unit
) {
    val skinAnalyses by homeScreenViewModel.skinAnalysesState
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
            RecommendedProductsUI(recommendedProduct)
        }
        item {
//            SkinCareRoutineUI()
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}


