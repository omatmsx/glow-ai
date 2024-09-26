package com.mindstix.capabilities.presentation.navigation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.mindstix.capabilities.presentation.navigation.BottomNavItem
import com.mindstix.capabilities.presentation.navigation.Destinations
import com.mindstix.capabilities.R

object BottomItems {
    // List of Bottom Navigation items, each representing a screen in the app.
    val items: List<BottomNavItem>
        @Composable
        get() = listOf(
            BottomNavItem(
                name = "Dashboard",
                route = Destinations.HomeDestination.route,
                icon = painterResource(id = R.drawable.ic_dashboard_icon),
            ),
            BottomNavItem(
                name = "Skin Care Routine ",
                route = Destinations.SkinCareRoutineScreenDestination.route,
                icon = painterResource(id = R.drawable.ic_skincare_icon),
            ),
            BottomNavItem(
                name = "Progress",
                route = Destinations.SettingsDestination.route,
                icon = painterResource(id = R.drawable.ic_progress_tracker),
            ),
        )
}
