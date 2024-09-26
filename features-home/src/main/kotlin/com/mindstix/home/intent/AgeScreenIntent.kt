package com.mindstix.home.intent

import com.mindstix.core.base.NavEffect
import com.mindstix.core.base.UserIntent
import com.mindstix.core.base.ViewState
import com.mindstix.home.model.AgeScreenDataModel

sealed class AgeScreenIntent : UserIntent {
    data object NavigateToHomeScreen: AgeScreenIntent()
}

sealed class AgeScreenNavEffect : NavEffect {
    data object NavigateToHomeScreen: AgeScreenNavEffect()
}

sealed class AgeScreenViewStates {

    data class LoadedData(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: AgeScreenDataModel,
    ) : AgeScreenViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
    ) : AgeScreenViewStates()

    data object UnInitialized : AgeScreenViewStates()
}

data class AgeScreenState(
    var ageScreenViewState: AgeScreenViewStates,
) : ViewState
