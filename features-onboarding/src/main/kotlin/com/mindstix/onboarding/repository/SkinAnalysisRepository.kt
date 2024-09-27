package com.mindstix.onboarding.repository

import com.google.gson.Gson
import com.mindstix.capabilities.database.dao.SkinAnalysisDao
import com.mindstix.capabilities.database.dao.SkinCareRoutineDao
import com.mindstix.capabilities.database.dao.SkincareProductDao
import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.database.entities.SkinCareRoutineEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.capabilities.network.rest.api.ApiConfig
import com.mindstix.capabilities.network.rest.model.ChatCompletionRequest
import com.mindstix.capabilities.network.rest.model.SkinAnalysisReportModel
import com.mindstix.capabilities.network.rest.model.WeatherResponse
import com.mindstix.onboarding.utils.RecommendedQueryBuilder
import com.mindstix.onboarding.utils.SkinCareQueryBuilder
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import java.io.File
import javax.inject.Inject

class SkinAnalysisRepository @Inject constructor(
    val apiConfig: ApiConfig,
    val skinAnalysisDao: SkinAnalysisDao,
    val skinCareRoutineDao: SkinCareRoutineDao,
    val skincareProductDao: SkincareProductDao,

    ) {

    suspend fun getSkinAnalysis(imageFile: File): Response<SkinAnalysisReportModel> {
        val mimeType = when (imageFile.extension.lowercase()) {
            "png" -> "image/png"
            "jpg", "jpeg" -> "image/jpeg"
            else -> throw IllegalArgumentException("Unsupported file type: ${imageFile.extension}")
        }
        val requestFile = RequestBody.create(mimeType.toMediaTypeOrNull(), imageFile)
        val imageBody = MultipartBody.Part.createFormData("image_file", imageFile.name, requestFile)
        return apiConfig.analyzeSkin(imageFile = imageBody)
    }

    suspend fun saveSkinAnalysis(body: SkinAnalysisEntity) {
        skinAnalysisDao.insertSkinAnalysis(body)
    }

    suspend fun getAllSkinAnalyses(): List<SkinAnalysisEntity> {
        return skinAnalysisDao.getAllSkinAnalyses()
    }

    suspend fun saveSkinCareRoutine(body: List<SkinCareRoutineEntity>) {
        skinCareRoutineDao.insertRoutine(body)
    }


    suspend fun saveSkincareProductEntity(body: List<SkincareProductEntity>) {
        skincareProductDao.insertProduct(body)
    }

    suspend fun getAllSuggestedProduct(): List<SkincareProductEntity> {
        return skincareProductDao.getAllProducts()
    }

    suspend fun getSkinCareRoutine(data: SkinAnalysisEntity): List<SkinCareRoutineEntity> {
        val convertedData = Gson().toJson(data)
        val response = apiConfig.createChatCompletion(
            ChatCompletionRequest.getObject(
                SkinCareQueryBuilder.getQuery(convertedData)
            )
        )
        var temp = response?.body()?.choices?.first()?.message?.content.toString()
        temp = temp.substring(7, temp.length - 3)
        val skincareTasks = Gson().fromJson(temp, Array<SkinCareRoutineEntity>::class.java).toList()
        return skincareTasks
    }

    suspend fun getRecommendedProducts(data: SkinAnalysisEntity): List<SkincareProductEntity> {
        val convertedData = Gson().toJson(data)
        val response = apiConfig.createChatCompletion(
            ChatCompletionRequest.getObject(
                RecommendedQueryBuilder.getQuery(convertedData)
            )
        )
        var temp = response?.body()?.choices?.first()?.message?.content.toString()
        temp = temp.substring(7, temp.length - 3)
        val skincareTasks = Gson().fromJson(temp, Array<SkincareProductEntity>::class.java).toList()
        return skincareTasks
    }

    suspend fun getWeather(
    ): WeatherResponse? {
        val response = apiConfig.createGetWeather()
        if (response != null) {
            if (response.isSuccessful) {
                // Handle the successful response
                val weatherResponse = response.body()
                println("weather response:- $weatherResponse")
            }
        }
        return response?.body()
    }

    suspend fun getTipOfDay(temp: String, weatherCondition: String, currentTime: String): String {
        val convertedTemp = Gson().toJson(temp)
        val convertedWeatherCond = Gson().toJson(weatherCondition)
        val convertedCurrentTime = Gson().toJson(currentTime)
        val response = apiConfig.createChatCompletion(
            ChatCompletionRequest.getObject(
                SkinCareQueryBuilder.getQueryForDayTip(
                    convertedTemp, convertedWeatherCond, convertedCurrentTime
                )
            )
        )
        return response?.body()?.choices?.first()?.message?.content.toString()
    }
}