package com.mindstix.capabilities.database.module

import com.mindstix.capabilities.database.dao.GlowAIDatabaseDao
import com.mindstix.capabilities.database.db.GlowAIDatabase


import android.content.Context
import com.mindstix.capabilities.database.dao.RecommendedMakeupProductDao
import com.mindstix.capabilities.database.dao.SkinAnalysisDao
import com.mindstix.capabilities.database.dao.SkinCareRoutineDao
import com.mindstix.capabilities.database.dao.SkincareProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing database-related dependencies.
 * This module will be installed in the SingletonComponent, meaning the provided dependencies
 * will live as long as the application does.
 */
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    /**
     * Provides a singleton instance of the [GlowAIDatabase].
     *
     * @param appContext The application context.
     * @return An instance of [GlowAIDatabase].
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): GlowAIDatabase {
        return GlowAIDatabase(appContext)
    }

    /**
     * Provides an instance of [GlowAIDatabaseDao].
     *
     * @param database The instance of [GlowAIDatabase].
     * @return An instance of [GlowAIDatabaseDao].
     */
    @Provides
    fun provideSampleDataDao(database: GlowAIDatabase): GlowAIDatabaseDao {
        return database.getDataAccessObject()
    }
    @Provides
    fun provideSkinAnalysisDao(database: GlowAIDatabase): SkinAnalysisDao {
        return database.getSkinAnalysisDao()
    }
    @Provides
    fun provideSkinCareRoutineDao(database: GlowAIDatabase): SkinCareRoutineDao {
        return database.getSkinCareRoutineDao()
    }
    @Provides
    fun provideSkincareProductDao(database: GlowAIDatabase):SkincareProductDao {
        return database.getSSkincareProductDao()
    }
    @Provides
    fun provideRecommendedMakeupProductDao(database: GlowAIDatabase): RecommendedMakeupProductDao {
        return database.getRecommendedMakeupProductDao()
    }

//    @Provides
//    fun provideNotificationDataLocalRepo(notificationsDao: GlowAIDatabaseDao): NotificationsDataLocalRepo {
//        return NotificationsDataLocalRepoImpl(notificationsDao)
//    }
}
