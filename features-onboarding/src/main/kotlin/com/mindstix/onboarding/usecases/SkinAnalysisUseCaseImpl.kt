package com.mindstix.onboarding.usecases

import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.mapper.SkinAnalysisMapper
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
                errorMessage = JSONObject(response.errorBody()!!.charStream().readText()).toString()
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

    override suspend fun getSkinAnalysisDataFromDB(): List<SkinAnalysisEntity> {

        val response = skinAnalysisRepository.getAllSkinAnalyses()
        println("response1: $response")
        return response
    }


}