package com.mindstix.onboarding.repository

import com.mindstix.capabilities.network.rest.api.ApiConfig
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import javax.inject.Inject

class SkinAnalysisRepository @Inject constructor(
    val apiConfig: ApiConfig
) {

    suspend fun getSkinAnalysis(imageFilePath:String){
        val imageFile = File(imageFilePath)
        val requestFile = RequestBody.create("image/jpeg".toMediaTypeOrNull(), imageFile)
        val imageBody = MultipartBody.Part.createFormData("image_file", imageFile.name, requestFile)
        apiConfig.analyzeSkin(imageFile = imageBody)
    }

}