/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */
package com.mindstix.capabilities.network.rest.api

import com.mindstix.capabilities.network.rest.model.AiResponseModel
import com.mindstix.capabilities.network.rest.model.ChatCompletionRequest
import com.mindstix.capabilities.network.rest.model.SkinAnalysisReportModel
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiConfig {

    @Multipart
    @POST("facepp/v1/skinanalyze")
    suspend fun analyzeSkin(
        @Part("api_key") apiKey: RequestBody = RequestBody.create(
            "text/plain".toMediaTypeOrNull(),
            "57KfWP6lsN58LJI__c4_cidUUwyt-ra0"
        ),
        @Part("api_secret") apiSecret: RequestBody = RequestBody.create(
            "text/plain".toMediaTypeOrNull(),
            "d6Mv_OjN0RYTOcNWW_TIgol4M9FsGmhC"
        ),
        @Part imageFile: MultipartBody.Part
    ): Response<SkinAnalysisReportModel>


    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer "
    )
    @POST("https://api.openai.com/v1/chat/completions")
    fun createChatCompletion(@Body request: ChatCompletionRequest?): Call<AiResponseModel?>?
}
