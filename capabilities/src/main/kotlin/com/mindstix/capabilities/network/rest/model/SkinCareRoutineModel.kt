package com.mindstix.capabilities.network.rest.model


import com.google.gson.annotations.SerializedName

data class SkinCareRoutineModelItem(
    @SerializedName("task")
    val task: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("whyWeShouldDoIt")
    val whyWeShouldDoIt: String
)