package com.mindstix.home.view.dashboard.modal

data class SkinAnalysisEntityDataModal(
    val poresLeftCheekConfidence: Double,
    val poresLeftCheekValue: Int,
    val eyePouchConfidence: Double,
    val eyePouchValue: Int,
    val foreheadWrinkleConfidence: Double,
    val foreheadWrinkleValue: Int,
    val skinSpotConfidence: Double,
    val skinSpotValue: Int,
    val acneConfidence: Double,
    val acneValue: Int,
    val poresForeheadConfidence: Double,
    val poresForeheadValue: Int,
    val eyeFinelinesConfidence: Double,
    val eyeFinelinesValue: Int,
    val darkCircleConfidence: Double,
    val darkCircleValue: Int,
    val poresRightCheekConfidence: Double,
    val poresRightCheekValue: Int,
    val blackheadConfidence: Double,
    val blackheadValue: Int,
    val skinType: String,
    //
    val nasolabialFoldConfidence: Double,
    val nasolabialFoldValue: Int,
    val poresJawConfidence: Double,
    val poresJawValue: Int,
    val leftEyelidsConfidence: Double,
    val leftEyelidsValue: Int,
    val crowsFeetConfidence: Double,
    val crowsFeetValue: Int,
    val glabellaWrinkleConfidence: Double,
    val glabellaWrinkleValue: Int,
    val moleConfidence: Double,
    val moleValue: Int,
    val rightEyelidsConfidence: Double,
    val rightEyelidsValue: Int
)

data class RecommendedProducts(
    val productName: String,
    val productImg: Int,
)


