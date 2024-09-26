package com.mindstix.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.mindstix.capabilities.presentation.navigation.Destinations
import com.mindstix.home.intent.ClickPictureScreenIntent
import com.mindstix.home.intent.ClickPictureScreenNavEffect
import com.mindstix.home.intent.ClickPictureScreenViewStates
import com.mindstix.home.view.uploadimage.ui.ClickPictureScreen
import com.mindstix.home.viewmodel.ClickPictureScreenViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun ClickPictureScreenDestination(
    clickPictureScreenViewModel: ClickPictureScreenViewModel,
    navEffect: Flow<ClickPictureScreenNavEffect>,
    navController: NavController,
){
    val state by clickPictureScreenViewModel.viewState.collectAsState()

    fun handleNavigation(navEvent: ClickPictureScreenNavEffect) {
        when(navEvent){
            is ClickPictureScreenNavEffect.NavigateToAgeScreen -> {
                navController.popBackStack()
                navController.navigate(Destinations.AgeScreenDestination.route)
            }
        }
    }

    LaunchedEffect(Unit) {
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    fun onUserAction(): (ClickPictureScreenIntent) -> Unit = {
        // Perform the specified user action using the ViewModel.
        clickPictureScreenViewModel.performAction(it)
    }

    ClickPictureScreen(
        userIntent = onUserAction(),
        state
    )
}