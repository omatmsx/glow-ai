package com.mindstix.onboarding.usecases

import com.mindstix.capabilities.mapper.SkinAnalysisMapper
import com.mindstix.onboarding.repository.SkinAnalysisRepository
import org.json.JSONObject
import java.io.File
import javax.inject.Inject

class SkinAnalysisUseCaseImpl @Inject constructor(
    val skinAnalysisRepository: SkinAnalysisRepository
) :
    SkinAnalysisUseCase {
    override suspend fun getSkinAnalysis(imageFilePath: File) {
        val response = skinAnalysisRepository.getSkinAnalysis(imageFilePath)
        val body = response.body()
        if (response.isSuccessful && body != null) {

            skinAnalysisRepository.saveSkinAnalysis(SkinAnalysisMapper.mapToEntity(body))

        } else {
            var errorMessage = "Api failed"
            try {
                errorMessage = JSONObject(response.errorBody()!!.charStream().readText()).toString()
            } catch (e: Exception) {
            }
            throw Throwable(message = errorMessage)
        }

    }

}