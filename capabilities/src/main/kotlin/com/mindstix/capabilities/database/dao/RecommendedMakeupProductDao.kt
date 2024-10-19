package com.mindstix.capabilities.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mindstix.capabilities.database.entities.RecommendedMakeupProductEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity

@Dao
interface RecommendedMakeupProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: List<RecommendedMakeupProductEntity>)

    @Query("SELECT * FROM makeup_product WHERE id = :productId")
    suspend fun getProductById(productId: Int): RecommendedMakeupProductEntity?

    @Query("SELECT * FROM makeup_product")
    suspend fun getAllProducts(): List<RecommendedMakeupProductEntity>

    @Query("DELETE FROM makeup_product WHERE id = :productId")
    suspend fun deleteProductById(productId: Int)
}
