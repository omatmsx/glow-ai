package com.mindstix.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.mindstix.home.intent.HomeScreenIntent
import com.mindstix.home.intent.HomeScreenNavEffect
import com.mindstix.home.view.HomeScreen
import com.mindstix.home.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeScreenDestination(
    homeScreenViewModel: HomeScreenViewModel,
    navEffect: Flow<HomeScreenNavEffect>,
    navController: NavController,
) {
    fun handleNavigation(navEvent: HomeScreenNavEffect) {

    }

    LaunchedEffect(Unit) {
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    fun onUserAction(): (HomeScreenIntent) -> Unit = {
        // Perform the specified user action using the ViewModel.
        homeScreenViewModel.performAction(it)
    }

    HomeScreen(
        homeScreenViewModel = homeScreenViewModel,
        userIntent = onUserAction()
    )
}