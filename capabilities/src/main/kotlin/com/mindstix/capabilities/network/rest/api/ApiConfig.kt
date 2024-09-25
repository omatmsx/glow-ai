/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */
package com.mindstix.capabilities.network.rest.api

import com.mindstix.core.models.SampleRequest
import com.mindstix.core.models.SampleResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

/**
 * API configurations interface for defining API calls.
 *
 * @author Abhijeet Kokane
 */
interface ApiConfig {

    @Multipart
    @POST("facepp/v1/skinanalyze")
    suspend fun analyzeSkin(
        @Part("api_key") apiKey: RequestBody = RequestBody.create(
            "text/plain".toMediaTypeOrNull(),
            "d6Mv_OjN0RYTOcNWW_TIgol4M9FsGmhC"
        ),
        @Part("api_secret") apiSecret: RequestBody = RequestBody.create(
            "text/plain".toMediaTypeOrNull(),
            "d6Mv_OjN0RYTOcNWW_TIgol4M9FsGmhC"
        ),
        @Part imageFile: MultipartBody.Part
    ): Call<String>
}
