package com.mindstix.capabilities.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "skincare_routine")
data class SkinCareRoutineEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Primary key for the database
    @SerializedName("task") val task: String,
    @SerializedName("time") val time: String,
    @SerializedName("whyWeShouldDoIt") val whyWeShouldDoIt: String,
    @SerializedName("productName") val productName: String,
    @SerializedName("whatItContains") val whatItContains: String,
)
