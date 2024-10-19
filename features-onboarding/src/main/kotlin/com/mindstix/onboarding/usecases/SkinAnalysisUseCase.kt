package com.mindstix.onboarding.usecases

import com.mindstix.capabilities.database.entities.RecommendedMakeupProductEntity
import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.capabilities.network.rest.model.WeatherResponse
import java.io.File

interface SkinAnalysisUseCase {

    suspend fun getSkinAnalysis(imageFilePath: File): SkinAnalysisEntity
    suspend fun getSkinCare(skinAnalysisEntity: SkinAnalysisEntity)
    suspend fun getRecommendedProducts(skinAnalysisEntity: SkinAnalysisEntity)
    suspend fun getListOfRecommendedProduct(): List<SkincareProductEntity>
    suspend fun getSkinAnalysisDataFromDB(): List<SkinAnalysisEntity>

    suspend fun getWeatherData(): WeatherResponse?

    suspend fun getTipOfTheDay(
        temp: String, weatherCondition: String, currentTime: String
    ): String

    suspend fun getRecommendedMakeUpProducts(skinAnalysisEntity: SkinAnalysisEntity)
    suspend fun getListOfRecommendedMakeupProduct(): List<RecommendedMakeupProductEntity>
}