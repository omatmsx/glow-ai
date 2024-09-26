package com.mindstix.home.intent

import com.mindstix.core.base.NavEffect
import com.mindstix.core.base.UserIntent
import com.mindstix.core.base.ViewState
import com.mindstix.home.model.ClickPictureScreenDataModel
import java.io.File

sealed class ClickPictureScreenIntent : UserIntent {
    data class NavigateToAgeScreen(val imagePath: File): ClickPictureScreenIntent()
}

sealed class ClickPictureScreenNavEffect : NavEffect {
    data object NavigateToAgeScreen: ClickPictureScreenNavEffect()
}

sealed class ClickPictureScreenViewStates {

    data class LoadedData(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: ClickPictureScreenDataModel,
    ) : ClickPictureScreenViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        var message:String=""
    ) : ClickPictureScreenViewStates()

    data class ErrorState(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        var message:String=""
    ) : ClickPictureScreenViewStates()

    data object UnInitialized : ClickPictureScreenViewStates()
}

data class ClickPictureScreenState(
    var ageScreenViewState: ClickPictureScreenViewStates,
) : ViewState