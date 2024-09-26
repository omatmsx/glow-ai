package com.mindstix.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.mindstix.home.intent.SkinCareRoutineScreenIntent
import com.mindstix.home.intent.SkinCareRoutineScreenNavEffect
import com.mindstix.home.intent.SkinCareRoutineScreenState
import com.mindstix.home.intent.SkinCareRoutineScreenViewStates
import com.mindstix.home.view.SkinCareRoutineScreen
import com.mindstix.home.viewmodel.SkinCareRoutineScreenViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun SkinCareRoutineScreenDestination(
    skinCareRoutineScreenViewModel: SkinCareRoutineScreenViewModel,
    skinCareRoutineScreenViewState: SkinCareRoutineScreenViewStates,
    navEffect: Flow<SkinCareRoutineScreenNavEffect>,
    navController: NavController,
) {
    fun handleNavigation(navEvent: SkinCareRoutineScreenNavEffect) {

    }

    LaunchedEffect(Unit) {
        skinCareRoutineScreenViewModel.performAction(SkinCareRoutineScreenIntent.GetSkinCareRoutineData)
        // Collect and handle navigation effects.
        navEffect.collect { handleNavigation(it) }
    }

    fun onUserAction(): (SkinCareRoutineScreenIntent) -> Unit = {
        // Perform the specified user action using the ViewModel.
        skinCareRoutineScreenViewModel.performAction(it)
    }

    when(skinCareRoutineScreenViewState){
        is SkinCareRoutineScreenViewStates.InitialLoading -> {
            skinCareRoutineScreenViewModel.emitLoading()
        }

        is SkinCareRoutineScreenViewStates.LoadedData -> {
            SkinCareRoutineScreen(
                skinCareRoutineScreenViewModel = skinCareRoutineScreenViewModel,
                state = skinCareRoutineScreenViewState,
                userIntent = onUserAction()
            )
        }

        else -> {}
    }


}