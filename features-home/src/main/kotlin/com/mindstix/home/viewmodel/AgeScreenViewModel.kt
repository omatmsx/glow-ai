package com.mindstix.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.mindstix.core.base.BaseViewModel
import com.mindstix.home.intent.AgeScreenIntent
import com.mindstix.home.intent.AgeScreenNavEffect
import com.mindstix.home.intent.AgeScreenState
import com.mindstix.home.intent.AgeScreenViewStates
import com.mindstix.home.model.AgeScreenDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AgeScreenViewModel @Inject constructor(
) : BaseViewModel<AgeScreenIntent, AgeScreenState, AgeScreenNavEffect>() {

    private val _showLoader = mutableStateOf(false)
    val showLoader: MutableState<Boolean> = _showLoader

    override fun createInitialState(): AgeScreenState {
        return AgeScreenState(AgeScreenViewStates.UnInitialized)
    }

    override fun handleIntent(intent: AgeScreenIntent) {
        when(intent){
            is AgeScreenIntent.NavigateToHomeScreen -> {
                sendNavEffect {
                    AgeScreenNavEffect.NavigateToHomeScreen
                }
            }
        }
    }

    private fun renderAgeScreen(ageScreenDataModel: AgeScreenDataModel) {
        emitViewState {
            copy(
                ageScreenViewState = AgeScreenViewStates.LoadedData(
                    showLoader = false,
                    data = ageScreenDataModel,
                ),
            )
        }
    }

    /**
     * Emits a loading state to update the UI when initial loading is in progress.
     */
    fun emitLoading() {
        emitViewState {
            copy(
                ageScreenViewState = AgeScreenViewStates.InitialLoading(
                    showLoader = true,
                ),
            )
        }
    }

    /**
     * Sets the visibility of the loader UI component based on the provided `visibility` parameter.
     */
    private fun progressLoader(visibility: Boolean) {
        _showLoader.value = visibility
    }
}