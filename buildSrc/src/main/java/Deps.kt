/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

/**
 * Object containing dependency versions for the project.
 *
 * @author Alhaj SIddiqui
 */
object Deps {
    // Core dependencies
    const val kore_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    const val navigation_common_ktx = "androidx.navigation:navigation-common-ktx:${Versions.navigation_common_ktx}"
    const val navigation_runtime_ktx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation_runtime_ktx}"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime}"
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose}"

    // Compose dependencies
    const val compose_bom = "androidx.compose:compose-bom:${Versions.compose_bom}"
    const val compose_ui = "androidx.compose.ui:ui"
    const val compose_ui_graphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val material3 = "androidx.compose.material3:material3:${Versions.material}"
    const val custom_view = "androidx.customview:customview:${Versions.custom_view}"
    const val custom_view_pooling = "androidx.customview:customview-poolingcontainer:${Versions.custom_view}"

    // Testing dependencies
    const val junit = "junit:junit:${Versions.junit}"
    const val test_ext_junit = "androidx.test.ext:junit:${Versions.test_ext_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val ui_test_junit4 = "androidx.compose.ui:ui-test-junit4"
    const val ui_tooling = "androidx.compose.ui:ui-tooling"
    const val ui_test_manifest = "androidx.compose.ui:ui-test-manifest"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val kotlinx_coroutines_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx_coroutines_test}"

    // Networking dependencies
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_gson}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"

    // Dagger and Hilt dependencies
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt_compiler_android = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler}"
    const val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_compiler}"

    // Other dependencies
    const val test_compose_bom = "androidx.compose:compose-bom:${Versions.test_compose_bom}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val viewmodel_lifecycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel_ktx}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // Splash Screen
    const val splash_screen =  "androidx.core:core-splashscreen:${Versions.splash_screen}"

    //Database
    const val room_db = "androidx.room:room-runtime:${Versions.db_version}"
    const val room_compiler_db = "androidx.room:room-compiler:${Versions.db_version}"
    const val room_ktx_db = "androidx.room:room-ktx:${Versions.db_version}"

}