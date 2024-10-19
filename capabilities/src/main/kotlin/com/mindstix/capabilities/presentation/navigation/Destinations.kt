/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.capabilities.presentation.navigation

/**
 * Sealed class representing different destinations in the app.
 *
 * @author Alhaj SIddiqui
 */
sealed class Destinations(val route: String) {
    object SplashDestination : Destinations("splash")
    object LoginDestination : Destinations("login")
    object HomeDestination : Destinations("home")
    object SkinCareRoutineScreenDestination : Destinations("skin_care_Screen")
    object SettingsDestination : Destinations("settings")
    object AgeScreenDestination : Destinations("age_screen")
    object ClickPictureScreenDestination : Destinations("click_picture_screen")

}
