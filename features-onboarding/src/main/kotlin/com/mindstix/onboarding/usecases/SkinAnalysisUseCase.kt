package com.mindstix.onboarding.usecases

import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import java.io.File

interface SkinAnalysisUseCase {

    suspend fun getSkinAnalysis(imageFilePath: File): SkinAnalysisEntity
    suspend fun getSkinCare(skinAnalysisEntity: SkinAnalysisEntity)
    suspend fun getRecommendedProducts(skinAnalysisEntity: SkinAnalysisEntity)
    suspend fun getListOfRecommendedProduct(): List<SkincareProductEntity>
    suspend fun getSkinAnalysisDataFromDB(): List<SkinAnalysisEntity>
}