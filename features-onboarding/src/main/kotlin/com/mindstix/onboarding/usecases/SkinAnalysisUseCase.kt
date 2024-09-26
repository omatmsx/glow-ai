package com.mindstix.onboarding.usecases

import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.network.rest.model.SkinAnalysisReportModel
import retrofit2.Response
import java.io.File

interface SkinAnalysisUseCase {

    suspend  fun getSkinAnalysis(imageFilePath:File):SkinAnalysisEntity
    suspend fun getSkinCare(skinAnalysisEntity: SkinAnalysisEntity)
    suspend fun getRecommendedProducts(skinAnalysisEntity: SkinAnalysisEntity)
}