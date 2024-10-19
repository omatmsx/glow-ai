/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */
package com.mindstix.baseline

import android.app.Application
import com.mindstix.core.logger.Logger
import com.mindstix.onboarding.utils.NotificationHelper
import dagger.hilt.android.HiltAndroidApp

/**
 * Main application class.
 *
 * This class serves as the entry point for the Mindstix Android application.
 * It extends the Android Application class, allowing initialization and setup
 * logic to be executed when the application starts.
 *
 * The @HiltAndroidApp annotation is used to enable Hilt for dependency injection.
 * Hilt is a dependency injection library for Android that simplifies the process
 * of managing dependencies and performing dependency injection in Android apps.
 *
 * @author Alhaj SIddiqui
 */
@HiltAndroidApp
class MindstixApplication : Application() {
    /**
     * Called when the application is starting.
     *
     * This method is overridden to provide a hook for initialization logic.
     * Any setup or initialization code specific to the application can be
     * placed here.
     */
    override fun onCreate() {
        super.onCreate()
        // Additional initialization logic can be added here
        // Based upon Variants and BUILD_TYPE we can enable Logging
        Logger.enableLogging()

        NotificationHelper(applicationContext).createNotificationChannel()
    }
}
