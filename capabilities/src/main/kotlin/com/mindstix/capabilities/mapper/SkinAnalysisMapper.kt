package com.mindstix.capabilities.mapper

import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.network.rest.model.SkinAnalysisReportModel

class SkinAnalysisMapper {

    companion object {


        fun mapToEntity(report: SkinAnalysisReportModel): SkinAnalysisEntity {
            return SkinAnalysisEntity(
                id = 0,
                acneConfidence = report.result.acne.confidence,
                acneValue = report.result.acne.value,
                blackheadConfidence = report.result.blackhead.confidence,
                blackheadValue = report.result.blackhead.value,
                crowsFeetConfidence = report.result.crowsFeet.confidence,
                crowsFeetValue = report.result.crowsFeet.value,
                darkCircleConfidence = report.result.darkCircle.confidence,
                darkCircleValue = report.result.darkCircle.value,
                eyeFinelinesConfidence = report.result.eyeFinelines.confidence,
                eyeFinelinesValue = report.result.eyeFinelines.value,
                eyePouchConfidence = report.result.eyePouch.confidence,
                eyePouchValue = report.result.eyePouch.value,
                foreheadWrinkleConfidence = report.result.foreheadWrinkle.confidence,
                foreheadWrinkleValue = report.result.foreheadWrinkle.value,
                glabellaWrinkleConfidence = report.result.glabellaWrinkle.confidence,
                glabellaWrinkleValue = report.result.glabellaWrinkle.value,
                leftEyelidsConfidence = report.result.leftEyelids.confidence,
                leftEyelidsValue = report.result.leftEyelids.value,
                moleConfidence = report.result.mole.confidence,
                moleValue = report.result.mole.value,
                nasolabialFoldConfidence = report.result.nasolabialFold.confidence,
                nasolabialFoldValue = report.result.nasolabialFold.value,
                poresForeheadConfidence = report.result.poresForehead.confidence,
                poresForeheadValue = report.result.poresForehead.value,
                poresJawConfidence = report.result.poresJaw.confidence,
                poresJawValue = report.result.poresJaw.value,
                poresLeftCheekConfidence = report.result.poresLeftCheek.confidence,
                poresLeftCheekValue = report.result.poresLeftCheek.value,
                poresRightCheekConfidence = report.result.poresRightCheek.confidence,
                poresRightCheekValue = report.result.poresRightCheek.value,
                rightEyelidsConfidence = report.result.rightEyelids.confidence,
                rightEyelidsValue = report.result.rightEyelids.value,
                skinSpotConfidence = report.result.skinSpot.confidence,
                skinSpotValue = report.result.skinSpot.value,
                skinType = getSkinType(report.result.skinType.skinType),
            )
        }

        fun getSkinType(skinType: Int) = when (skinType) {
            0 -> "oily skin"
            1 -> "dry skin"
            2 -> "normal skin"
            else -> "mixed skin"
        }

        private fun mapSkinTypeDetails(details: SkinAnalysisReportModel.Result.SkinType.Details): String {
            return """
            Detail 0: Confidence = ${details.x0.confidence}, Value = ${details.x0.value}
            Detail 1: Confidence = ${details.x1.confidence}, Value = ${details.x1.value}
            Detail 2: Confidence = ${details.x2.confidence}, Value = ${details.x2.value}
            Detail 3: Confidence = ${details.x3.confidence}, Value = ${details.x3.value}
        """.trimIndent() // Customize as needed for storage
        }
    }
}
