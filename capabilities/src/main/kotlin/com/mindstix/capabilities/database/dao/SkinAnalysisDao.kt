package com.mindstix.capabilities.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import dagger.Provides

@Dao
interface SkinAnalysisDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkinAnalysis(skinAnalysis: SkinAnalysisEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkinAnalyses(skinAnalyses: List<SkinAnalysisEntity>)

    @Query("SELECT * FROM skin_analysis WHERE id = :id")
    suspend fun getSkinAnalysisById(id: Long): SkinAnalysisEntity?

    @Query("SELECT * FROM skin_analysis ORDER BY id DESC")
    suspend fun getAllSkinAnalyses(): List<SkinAnalysisEntity>

    @Update
    suspend fun updateSkinAnalysis(skinAnalysis: SkinAnalysisEntity)

    @Delete
    suspend fun deleteSkinAnalysis(skinAnalysis: SkinAnalysisEntity)

    @Query("DELETE FROM skin_analysis")
    suspend fun deleteAllSkinAnalyses()
}
