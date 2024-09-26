package com.mindstix.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.mindstix.core.base.BaseViewModel
import com.mindstix.home.intent.HomeScreenIntent
import com.mindstix.home.intent.HomeScreenNavEffect
import com.mindstix.home.intent.HomeScreenState
import com.mindstix.home.intent.HomeScreenViewStates
import com.mindstix.home.model.HomeScreenDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
) : BaseViewModel<HomeScreenIntent, HomeScreenState, HomeScreenNavEffect>() {

    private val _showLoader = mutableStateOf(false)
    val showLoader: MutableState<Boolean> = _showLoader

    override fun createInitialState(): HomeScreenState {
        return HomeScreenState(HomeScreenViewStates.UnInitialized)
    }

    override fun handleIntent(intent: HomeScreenIntent) {

    }

    private fun renderHomeScreen(ageScreenDataModel: HomeScreenDataModel) {
        emitViewState {
            copy(
                ageScreenViewState = HomeScreenViewStates.LoadedData(
                    showLoader = false,
                    data = ageScreenDataModel,
                ),
            )
        }
    }

    fun emitLoading() {
        emitViewState {
            copy(
                ageScreenViewState = HomeScreenViewStates.InitialLoading(
                    showLoader = true,
                ),
            )
        }
    }


    private fun progressLoader(visibility: Boolean) {
        _showLoader.value = visibility
    }
}