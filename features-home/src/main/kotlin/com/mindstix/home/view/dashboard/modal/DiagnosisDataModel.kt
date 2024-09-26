package com.mindstix.home.view.dashboard.modal

import androidx.compose.ui.graphics.painter.Painter

data class DiagnosisDataModel(
    val conditionName: String,
    val confidence: Int,
    val imagePainter: Painter
)