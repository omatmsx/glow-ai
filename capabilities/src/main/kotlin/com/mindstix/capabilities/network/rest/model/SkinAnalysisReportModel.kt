package com.mindstix.capabilities.network.rest.model


import com.google.gson.annotations.SerializedName

data class SkinAnalysisReportModel(
    @SerializedName("face_rectangle")
    val faceRectangle: FaceRectangle,
    @SerializedName("request_id")
    val requestId: String,
    @SerializedName("result")
    val result: Result,
    @SerializedName("time_used")
    val timeUsed: Int,
    @SerializedName("warning")
    val warning: List<Any>
) {
    data class FaceRectangle(
        @SerializedName("height")
        val height: Int,
        @SerializedName("left")
        val left: Int,
        @SerializedName("top")
        val top: Int,
        @SerializedName("width")
        val width: Int
    )

    data class Result(
        @SerializedName("acne")
        val acne: Acne,
        @SerializedName("blackhead")
        val blackhead: Blackhead,
        @SerializedName("crows_feet")
        val crowsFeet: CrowsFeet,
        @SerializedName("dark_circle")
        val darkCircle: DarkCircle,
        @SerializedName("eye_finelines")
        val eyeFinelines: EyeFinelines,
        @SerializedName("eye_pouch")
        val eyePouch: EyePouch,
        @SerializedName("forehead_wrinkle")
        val foreheadWrinkle: ForeheadWrinkle,
        @SerializedName("glabella_wrinkle")
        val glabellaWrinkle: GlabellaWrinkle,
        @SerializedName("left_eyelids")
        val leftEyelids: LeftEyelids,
        @SerializedName("mole")
        val mole: Mole,
        @SerializedName("nasolabial_fold")
        val nasolabialFold: NasolabialFold,
        @SerializedName("pores_forehead")
        val poresForehead: PoresForehead,
        @SerializedName("pores_jaw")
        val poresJaw: PoresJaw,
        @SerializedName("pores_left_cheek")
        val poresLeftCheek: PoresLeftCheek,
        @SerializedName("pores_right_cheek")
        val poresRightCheek: PoresRightCheek,
        @SerializedName("right_eyelids")
        val rightEyelids: RightEyelids,
        @SerializedName("skin_spot")
        val skinSpot: SkinSpot,
        @SerializedName("skin_type")
        val skinType: SkinType
    ) {
        data class Acne(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class Blackhead(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class CrowsFeet(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class DarkCircle(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class EyeFinelines(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class EyePouch(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class ForeheadWrinkle(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class GlabellaWrinkle(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class LeftEyelids(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class Mole(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class NasolabialFold(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class PoresForehead(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class PoresJaw(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class PoresLeftCheek(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class PoresRightCheek(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class RightEyelids(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class SkinSpot(
            @SerializedName("confidence")
            val confidence: Double,
            @SerializedName("value")
            val value: Int
        )

        data class SkinType(
            @SerializedName("details")
            val details: Details,
            @SerializedName("skin_type")
            val skinType: Int
        ) {
            data class Details(
                @SerializedName("0")
                val x0: X0,
                @SerializedName("1")
                val x1: X1,
                @SerializedName("2")
                val x2: X2,
                @SerializedName("3")
                val x3: X3
            ) {
                data class X0(
                    @SerializedName("confidence")
                    val confidence: Double,
                    @SerializedName("value")
                    val value: Int
                )

                data class X1(
                    @SerializedName("confidence")
                    val confidence: Double,
                    @SerializedName("value")
                    val value: Int
                )

                data class X2(
                    @SerializedName("confidence")
                    val confidence: Double,
                    @SerializedName("value")
                    val value: Int
                )

                data class X3(
                    @SerializedName("confidence")
                    val confidence: Double,
                    @SerializedName("value")
                    val value: Int
                )
            }
        }
    }
}