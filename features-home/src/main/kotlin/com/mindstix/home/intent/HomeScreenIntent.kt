package com.mindstix.home.intent

import com.mindstix.core.base.NavEffect
import com.mindstix.core.base.UserIntent
import com.mindstix.core.base.ViewState
import com.mindstix.home.model.HomeScreenDataModel

sealed class HomeScreenIntent : UserIntent {
    object GetSkinAnalysisData : HomeScreenIntent()
    object GetRecommendedProducts : HomeScreenIntent()

    object GetWeatherData : HomeScreenIntent()
}

sealed class HomeScreenNavEffect : NavEffect {

}

sealed class HomeScreenViewStates {

    data class LoadedData(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: HomeScreenDataModel,
    ) : HomeScreenViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
    ) : HomeScreenViewStates()

    data object UnInitialized : HomeScreenViewStates()
}

data class HomeScreenState(
    var ageScreenViewState: HomeScreenViewStates,
) : ViewState
