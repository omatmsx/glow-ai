package com.mindstix.capabilities.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skin_analysis")
data class SkinAnalysisEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,  // Unique ID for each entry
    val poresLeftCheekConfidence: Double,
    val poresLeftCheekValue: Int,
    val nasolabialFoldConfidence: Double,
    val nasolabialFoldValue: Int,
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
    val poresJawConfidence: Double,
    val poresJawValue: Int,
    val leftEyelidsConfidence: Double,
    val leftEyelidsValue: Int,
    val eyeFinelinesConfidence: Double,
    val eyeFinelinesValue: Int,
    val darkCircleConfidence: Double,
    val darkCircleValue: Int,
    val crowsFeetConfidence: Double,
    val crowsFeetValue: Int,
    val poresRightCheekConfidence: Double,
    val poresRightCheekValue: Int,
    val blackheadConfidence: Double,
    val blackheadValue: Int,
    val glabellaWrinkleConfidence: Double,
    val glabellaWrinkleValue: Int,
    val moleConfidence: Double,
    val moleValue: Int,
    val skinType: String,
    val rightEyelidsConfidence: Double,
    val rightEyelidsValue: Int
)
