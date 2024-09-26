package com.mindstix.onboarding.repository

import com.mindstix.capabilities.database.dao.SkinAnalysisDao
import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.network.rest.api.ApiConfig
import com.mindstix.capabilities.network.rest.model.SkinAnalysisReportModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class SkinAnalysisRepository @Inject constructor(
    val apiConfig: ApiConfig,
    val skinAnalysisDao: SkinAnalysisDao
) {

    suspend fun getSkinAnalysis(imageFile:File): Response<SkinAnalysisReportModel> {
        val mimeType = when (imageFile.extension.lowercase()) {
            "png" -> "image/png"
            "jpg", "jpeg" -> "image/jpeg"
            else -> throw IllegalArgumentException("Unsupported file type: ${imageFile.extension}")
        }
        imageFile.absolutePath
        val requestFile = RequestBody.create(mimeType.toMediaTypeOrNull(), imageFile)
        val imageBody = MultipartBody.Part.createFormData("image_file", imageFile.name, requestFile)
        return apiConfig.analyzeSkin(imageFile = imageBody)
    }

    suspend fun saveSkinAnalysis(body: SkinAnalysisEntity) {
        skinAnalysisDao.insertSkinAnalysis(body)
    }

}