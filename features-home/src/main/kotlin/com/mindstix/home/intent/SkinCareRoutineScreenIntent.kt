package com.mindstix.home.intent

import com.mindstix.core.base.NavEffect
import com.mindstix.core.base.UserIntent
import com.mindstix.core.base.ViewState
import com.mindstix.home.model.SkinCareRoutineScreenDataModel

sealed class SkinCareRoutineScreenIntent : UserIntent {
    data object GetSkinCareRoutineData : SkinCareRoutineScreenIntent()
}

sealed class SkinCareRoutineScreenNavEffect : NavEffect {

}

sealed class SkinCareRoutineScreenViewStates {

    data class LoadedData(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
        val data: SkinCareRoutineScreenDataModel,
    ) : SkinCareRoutineScreenViewStates()

    data class InitialLoading(
        val showLoader: Boolean = false,
        val isRefreshing: Boolean = false,
    ) : SkinCareRoutineScreenViewStates()

    data object UnInitialized : SkinCareRoutineScreenViewStates()
}

data class SkinCareRoutineScreenState(
    var skinCareRoutineScreenViewState: SkinCareRoutineScreenViewStates,
) : ViewState