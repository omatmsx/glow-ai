package com.mindstix.capabilities.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mindstix.capabilities.database.entities.UserDataEntity
import com.mindstix.capabilities.database.utils.USER_TABLE

@Dao
abstract class GlowAIDatabaseDao {
    @Query("SELECT * FROM $USER_TABLE")
    internal abstract suspend fun fetchNotificationsListData(): UserDataEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertUserDataEntity(notificationEntity: UserDataEntity)
}