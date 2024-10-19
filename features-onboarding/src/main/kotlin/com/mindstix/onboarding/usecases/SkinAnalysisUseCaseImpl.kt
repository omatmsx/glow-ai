package com.mindstix.onboarding.usecases

import com.mindstix.capabilities.database.entities.RecommendedMakeupProductEntity
import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.capabilities.mapper.SkinAnalysisMapper
import com.mindstix.capabilities.network.rest.model.WeatherResponse
import com.mindstix.onboarding.repository.SkinAnalysisRepository
import com.mindstix.onboarding.utils.SharedPreferenceManager
import org.json.JSONObject
import java.io.File
import javax.inject.Inject

class SkinAnalysisUseCaseImpl @Inject constructor(
    val skinAnalysisRepository: SkinAnalysisRepository,
    private val sharedPreferenceManager: SharedPreferenceManager
) : SkinAnalysisUseCase {
    override suspend fun getSkinAnalysis(imageFilePath: File): SkinAnalysisEntity {
        val response = skinAnalysisRepository.getSkinAnalysis(imageFilePath)
        val body = response.body()

        if (!response.isSuccessful || body == null) {
            var errorMessage = "Api failed"
            try {
                errorMessage = JSONObject(
                    response.errorBody()!!.charStream().readText()
                ).optString("error_message")
            } catch (_: Exception) {
            }
            throw Throwable(message = errorMessage)
        }

        val skinAnalysisEntity = SkinAnalysisMapper.mapToEntity(body)

        skinAnalysisRepository.saveSkinAnalysis(skinAnalysisEntity)

        return skinAnalysisEntity
    }

    override suspend fun getSkinCare(skinAnalysisEntity: SkinAnalysisEntity) {
        val skinCare = skinAnalysisRepository.getSkinCareRoutine(skinAnalysisEntity)
        skinAnalysisRepository.saveSkinCareRoutine(skinCare)
    }

    override suspend fun getRecommendedProducts(skinAnalysisEntity: SkinAnalysisEntity) {
        val recommendedProducts = skinAnalysisRepository.getRecommendedProducts(skinAnalysisEntity)
        skinAnalysisRepository.saveSkincareProductEntity(recommendedProducts)

        sharedPreferenceManager.isLoggedIn = true
    }

    override suspend fun getRecommendedMakeUpProducts(skinAnalysisEntity: SkinAnalysisEntity) {
        val recommendedProducts = skinAnalysisRepository.getRecommendedMakeUpProducts(skinAnalysisEntity)
        skinAnalysisRepository.saveMakeUpProductEntity(recommendedProducts)
    }

    override suspend fun getListOfRecommendedProduct(): List<SkincareProductEntity> {
        val response = skinAnalysisRepository.getAllSuggestedProduct()
        println("response1: $response")
        return response
    }

    override suspend fun getListOfRecommendedMakeupProduct(): List<RecommendedMakeupProductEntity> {
        val response = skinAnalysisRepository.getAllRecommendedMakeupProduct()
        println("response1: $response")
        return response
    }

    override suspend fun getSkinAnalysisDataFromDB(): List<SkinAnalysisEntity> {

        val response = skinAnalysisRepository.getAllSkinAnalyses()
        println("response1: $response")
        return response
    }

    override suspend fun getWeatherData(
    ): WeatherResponse? {
        val response = skinAnalysisRepository.getWeather()
        println("Weather Response: $response")
        return response
    }

    override suspend fun getTipOfTheDay(
        temp: String,
        weatherCondition: String,
        currentTime: String
    ): String {
        return skinAnalysisRepository.getTipOfDay(
            temp = temp,
            weatherCondition = weatherCondition,
            currentTime = currentTime
        )
    }
}