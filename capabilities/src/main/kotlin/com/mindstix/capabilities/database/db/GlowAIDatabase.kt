package com.mindstix.capabilities.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mindstix.capabilities.database.dao.GlowAIDatabaseDao
import com.mindstix.capabilities.database.entities.UserDataEntity
import com.mindstix.capabilities.database.utils.Converters
import com.mindstix.core.logger.Logger
import java.util.concurrent.Executors

/**
 * This class defines the Room database for the application.
 * It includes the entities and the version of the database.
 */
@Database(
    entities = [
        UserDataEntity::class,
    ],
    version = 2,
    exportSchema = false,
)
@TypeConverters(Converters::class) // Define the type converters for custom types.
abstract class GlowAIDatabase : RoomDatabase() {

    /**
     * Abstract method to get the GlowAIDatabaseDao.
     *
     * @return An instance of GlowAIDatabaseDao.
     */
    abstract fun getDataAccessObject(): GlowAIDatabaseDao

    companion object {
        private const val DB_NAME = "GlowAI-Database.db" // Name of the database.

        @Volatile
        private var instance: GlowAIDatabase? = null // Volatile instance of the database.
        private val LOCK = Any() // Lock for synchronization.

        /**
         * Operator function to get the database instance.
         *
         * @param context The application context.
         * @return The singleton instance of GlowAIDatabase.
         */
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        /**
         * Builds the Room database.
         *
         * @param context The application context.
         * @return The built instance of GlowAIDatabase.
         */
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
