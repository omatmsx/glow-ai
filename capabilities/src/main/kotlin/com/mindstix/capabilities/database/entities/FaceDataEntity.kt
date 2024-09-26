package com.mindstix.capabilities.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mindstix.capabilities.database.utils.FACE_DATA_TABLE
import com.mindstix.core.utils.EMPTY_STRING

@Entity(
    tableName = FACE_DATA_TABLE,
    indices = [Index(value = ["id"], unique = true)],
)
data class FaceDataEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "date_time")
    var dateTime: String? = EMPTY_STRING,

    @ColumnInfo(name = "pores_left_cheek_confidence")
    var poresLeftCheekConfidence: Double? = 0.0,

    @ColumnInfo(name = "pores_left_cheek_value")
    var poresLeftCheekValue: Int? = 0,

    @ColumnInfo(name = "nasolabial_fold_confidenece")
    var nasolabialFoldConfidence: Double? = 0.0,

    @ColumnInfo(name = "nasolabial_fold_value")
    var nasolabialFoldValue: Int? = 0,

    @ColumnInfo(name = "eye_pouch_confidenece")
    var eyePouchConfidence: Double? = 0.0,

    @ColumnInfo(name = "eye_pouch_value")
    var eyePouchValue: Int? = 0,

    @ColumnInfo(name = "forhead_wrinkle_confidenece")
    var forheadWrinkleConfidence: Double? = 0.0,

    @ColumnInfo(name = "forhead_wrinkle_value")
    var forheadWrinkleValue: Int? = 0,

    @ColumnInfo(name = "skin_spot_confidence")
    var skinSpotConfidence: Double? = 0.0,

    @ColumnInfo(name = "skin_spot_value")
    var skinSpotValue: Int? = 0,

    @ColumnInfo(name = "acne_confidence")
    var acneConfidence: Double? = 0.0,

    @ColumnInfo(name = "acne_value")
    var acneValue: Int? = 0,

    @ColumnInfo(name = "pores_forehead_confidence")
    var poresForeheadConfidence: Double? = 0.0,

    @ColumnInfo(name = "pores_forehead_value")
    var poresForeheadValue: Int? = 0,

    @ColumnInfo(name = "pores_jaw_confidence")
    var poresJawConfidence: Double? = 0.0,

    @ColumnInfo(name = "pores_jaw_value")
    var poresJawValue: Int? = 0,

    @ColumnInfo(name = "left_eyelids_confidence")
    var leftEyelidsConfidence: Double? = 0.0,

    @ColumnInfo(name = "left_eyelids_value")
    var leftEyelidsValue: Int? = 0,

    @ColumnInfo(name = "eye_finelines_confidence")
    var eyeFinelinesConfidence: Double? = 0.0,

    @ColumnInfo(name = "eye_finelines_value")
    var eyeFinelinesValue: Int? = 0,

    @ColumnInfo(name = "dark_circle_confidence")
    var darkCircleConfidence: Double? = 0.0,

    @ColumnInfo(name = "dark_circle_value")
    var darkCircleValue: Int? = 0,

    @ColumnInfo(name = "crows_feet_confidence")
    var crowsFeetConfidence: Double? = 0.0,

    @ColumnInfo(name = "crows_feet_value")
    var crowsFeetValue: Int? = 0,

    @ColumnInfo(name = "pores_right_cheek_confidence")
    var poresRightCheekConfidence: Double? = 0.0,

    @ColumnInfo(name = "pores_right_cheek_value")
    var poresRightCheekValue: Int? = 0,

    @ColumnInfo(name = "blackhead_confidence")
    var blackheadConfidence: Double? = 0.0,

    @ColumnInfo(name = "blackhead_value")
    var blackheadValue: Int? = 0,

    @ColumnInfo(name = "glabella_wrinkle_confidence")
    var glabellaWrinkleConfidence: Double? = 0.0,

    @ColumnInfo(name = "glabella_wrinkle_value")
    var glabellaWrinkleValue: Int? = 0,

    @ColumnInfo(name = "mole_confidence")
    var moleConfidence: Double? = 0.0,

    @ColumnInfo(name = "mole_value")
    var moleValue: Int? = 0,

    @ColumnInfo(name = "skin_type_0_confidence")
    var skinType0Confidence: Double? = 0.0,

    @ColumnInfo(name = "skin_type_0_value")
    var skinType0Value: Int? = 0,

    @ColumnInfo(name = "skin_type_1_confidence")
    var skinType1Confidence: Double? = 0.0,

    @ColumnInfo(name = "skin_type_1_value")
    var skinType1Value: Int? = 0,

    @ColumnInfo(name = "skin_type_2_confidence")
    var skinType2Confidence: Double? = 0.0,

    @ColumnInfo(name = "skin_type_2_value")
    var skinType2Value: Int? = 0,

    @ColumnInfo(name = "skin_type_3_confidence")
    var skinType3Confidence: Double? = 0.0,

    @ColumnInfo(name = "skin_type_3_value")
    var skinType3Value: Int? = 0,

    @ColumnInfo(name = "skin_type_description")
    var skinTypeDescription: String? = "normal skin"
)
