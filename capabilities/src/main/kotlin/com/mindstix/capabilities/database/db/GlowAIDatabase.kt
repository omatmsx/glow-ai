package com.mindstix.capabilities.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mindstix.capabilities.database.dao.GlowAIDatabaseDao
import com.mindstix.capabilities.database.dao.RecommendedMakeupProductDao
import com.mindstix.capabilities.database.dao.SkinAnalysisDao
import com.mindstix.capabilities.database.dao.SkinCareRoutineDao
import com.mindstix.capabilities.database.dao.SkincareProductDao
import com.mindstix.capabilities.database.entities.RecommendedMakeupProductEntity
import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.database.entities.SkinCareRoutineEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.capabilities.database.entities.UserDataEntity
import com.mindstix.capabilities.database.utils.Converters
import com.mindstix.core.logger.Logger
import java.util.concurrent.Executors

@Database(
    entities = [
        UserDataEntity::class,
        SkinAnalysisEntity::class,
        SkinCareRoutineEntity::class,
        SkincareProductEntity::class,
        RecommendedMakeupProductEntity::class,
    ],
    version = 2,
    exportSchema = false,
)
@TypeConverters(Converters::class) // Define the type converters for custom types.
abstract class GlowAIDatabase : RoomDatabase() {

    abstract fun getDataAccessObject(): GlowAIDatabaseDao
    abstract fun getSkinAnalysisDao(): SkinAnalysisDao
    abstract fun getSkinCareRoutineDao(): SkinCareRoutineDao
    abstract fun getSSkincareProductDao(): SkincareProductDao
    abstract fun getRecommendedMakeupProductDao(): RecommendedMakeupProductDao

    companion object {
        private const val DB_NAME = "GlowAI-Database.db" // Name of the database.

        @Volatile
        private var instance: GlowAIDatabase? = null // Volatile instance of the database.
        private val LOCK = Any() // Lock for synchronization.

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            GlowAIDatabase::class.java,
            DB_NAME,
        )
            .setQueryCallback(
                { sqlQuery, bindArgs ->
                    Logger.d { "RoomDB SQL Query: $sqlQuery SQL Args: ${bindArgs.joinToString()}" }
                },
                Executors.newSingleThreadExecutor(),
            )
            .fallbackToDestructiveMigration() // Fallback to destructive migration if no migration is provided.
            .build()
    }
}
