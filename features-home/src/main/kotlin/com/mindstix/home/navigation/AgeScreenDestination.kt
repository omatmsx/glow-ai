package com.mindstix.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.mindstix.capabilities.presentation.navigation.Destinations
import com.mindstix.home.intent.AgeScreenIntent
import com.mindstix.home.intent.AgeScreenNavEffect
import com.mindstix.home.view.AgeScreen
import com.mindstix.home.viewmodel.AgeScreenViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun AgeScreenDestination(
    ageScreenViewModel: AgeScreenViewModel,
    navEffect: Flow<AgeScreenNavEffect>,
    navController: NavController,
) {
    fun handleNavigation(navEvent: AgeScreenNavEffect) {
        when (navEvent) {
            is AgeScreenNavEffect.NavigateToHomeScreen -> {
                navController.popBackStack()
                navController.navigate(Destinations.HomeDestination.route)
            }
        }
    }

    LaunchedEffect(Unit) {
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    fun onUserAction(): (AgeScreenIntent) -> Unit = {
        // Perform the specified user action using the ViewModel.
        ageScreenViewModel.performAction(it)
    }

    AgeScreen(
        userIntent = onUserAction()
    )
}
