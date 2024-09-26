package com.mindstix.capabilities.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skincare_product")
data class SkincareProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val productName: String,
    val whatItContains: String,
    val whyWeShouldDoIt: String,
    val productImage: String
)
