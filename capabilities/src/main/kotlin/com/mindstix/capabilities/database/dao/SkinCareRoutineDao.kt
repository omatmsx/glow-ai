package com.mindstix.capabilities.database.dao
import androidx.room.*
import com.mindstix.capabilities.database.entities.SkinCareRoutineEntity

@Dao
interface SkinCareRoutineDao {
    @Query("SELECT * FROM skincare_routine")
    suspend fun getAllRoutines(): List<SkinCareRoutineEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoutine(routine: SkinCareRoutineEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoutine(routine: List<SkinCareRoutineEntity>)

    @Delete
    suspend fun deleteRoutine(routine: SkinCareRoutineEntity)
}
