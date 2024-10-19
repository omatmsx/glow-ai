/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

/**
 * Object containing build time configurations.
 *
 * @author Alhaj SIddiqui
 */
object BuildConfig {
    // Android build configuration
    const val compileSdk = 34
    const val minSdk = 29
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"

    // Kotlin and JVM configuration
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.5.6"

    const val applicationId = "com.mindstix.baseline"
    const val appName = "GlowAI"
}

// Object representing configurations specific to the India flavor
object India {
    const val suffix = ".india"
}

// Object representing configurations specific to the UAT flavor
object UAT {
    const val versionName = "1.0.0"
    const val prefix = "UAT-"
    const val suffix = "-UAT"
    const val dimensions = "app"
    const val extension = "${BuildConfig.applicationId}.uat"
    const val appName = BuildConfig.appName
}

// Object representing configurations specific to the QA flavor
object QA {
    const val versionName = "1.0.0"
    const val prefix = "QA"
    const val suffix = "QA"
    const val dimensions = "app"
    const val extension = "${BuildConfig.applicationId}.qa"
    const val appName = BuildConfig.appName
}

// Object representing configurations specific to the DEV flavor
object DEV {
    const val versionName = "1.0.0"
    const val prefix = "DEV-"
    const val suffix = "-DEV"
    const val dimensions = "app"
    const val extension = "${BuildConfig.applicationId}.dev"
    const val appName = BuildConfig.appName
}

// Object representing configurations specific to the PROD flavor
object PROD {
    const val versionName = "1.0.0"
    const val prefix = ""
    const val suffix = ""
    const val dimensions = "app"
    const val extension = BuildConfig.applicationId
    const val appName = BuildConfig.appName
}
