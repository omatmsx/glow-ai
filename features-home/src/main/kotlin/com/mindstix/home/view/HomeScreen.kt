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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
            imagePainter = painterResource(id = R.drawable.ic_acne) // Replace with your image
        ), DiagnosisDataModel(
            conditionName = "Acne1",
            confidence = 20,
            imagePainter = painterResource(id = R.drawable.ic_acne1) // Replace with your image
        ), DiagnosisDataModel(
            conditionName = "Acne2",
            confidence = 20,
            imagePainter = painterResource(id = R.drawable.ic_acne2) // Replace with your image
        ), DiagnosisDataModel(
            conditionName = "Acne3",
            confidence = 20,
            imagePainter = painterResource(id = R.drawable.ic_acne3) // Replace with your image
        ), DiagnosisDataModel(
            conditionName = "Acne4",
            confidence = 20,
            imagePainter = painterResource(id = R.drawable.ic_acne4) // Replace with your image
        )

    )
    LazyColumn(
        verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxHeight()
    ) {
        item {
            SkinAnalysisUI()
        }

        item {
            DiagnosisList(items = sampleItems, onItemClick = {})
        }
        item {
            RecommendedProductsUI()
        }
        item {
//            SkinCareRoutineUI()
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}


