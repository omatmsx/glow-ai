/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.home.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mindstix.core.R
import com.mindstix.home.view.dashboard.modal.DiagnosisDataModel
import com.mindstix.home.view.dashboard.ui.DiagnosisList
import com.mindstix.home.view.dashboard.ui.RecommendedProductsUI
import com.mindstix.home.view.dashboard.ui.SkinAnalysisUI

/**
 * Composable function representing the Home Screen.
 */
@SuppressLint("Recycle")
@Composable
fun HomeScreen() {
//    CameraGalleryProfileInfo()
    val sampleItems = listOf(
        DiagnosisDataModel(
            conditionName = "Acne",
            confidence = 20,
            imagePainter = painterResource(id = R.drawable.baseline_image_24) // Replace with your image
        ), DiagnosisDataModel(
            conditionName = "Acne",
            confidence = 20,
            imagePainter = painterResource(id = R.drawable.baseline_image_24) // Replace with your image
        ), DiagnosisDataModel(
            conditionName = "Acne",
            confidence = 20,
            imagePainter = painterResource(id = R.drawable.baseline_image_24) // Replace with your image
        )
    )

    Column(
        verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize()
    ) {
        SkinAnalysisUI()
        DiagnosisList(items = sampleItems, onItemClick = {})
        RecommendedProductsUI()
    }
}


