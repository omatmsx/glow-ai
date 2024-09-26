package com.mindstix.capabilities.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mindstix.capabilities.database.entities.SkincareProductEntity

@Dao
interface SkincareProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: List<SkincareProductEntity>)

    @Query("SELECT * FROM skincare_product WHERE id = :productId")
    suspend fun getProductById(productId: Int): SkincareProductEntity?

    @Query("SELECT * FROM skincare_product")
    suspend fun getAllProducts(): List<SkincareProductEntity>

    @Query("DELETE FROM skincare_product WHERE id = :productId")
    suspend fun deleteProductById(productId: Int)
}
