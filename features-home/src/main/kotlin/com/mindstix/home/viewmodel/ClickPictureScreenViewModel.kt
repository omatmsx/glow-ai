package com.mindstix.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.mindstix.core.base.BaseViewModel
import com.mindstix.home.intent.ClickPictureScreenIntent
import com.mindstix.home.intent.ClickPictureScreenNavEffect
import com.mindstix.home.intent.ClickPictureScreenState
import com.mindstix.home.intent.ClickPictureScreenViewStates
import com.mindstix.home.model.ClickPictureScreenDataModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClickPictureScreenViewModel @Inject constructor(
) : BaseViewModel<ClickPictureScreenIntent, ClickPictureScreenState, ClickPictureScreenNavEffect>() {

    private val _showLoader = mutableStateOf(false)
    val showLoader: MutableState<Boolean> = _showLoader

    override fun createInitialState(): ClickPictureScreenState {
        return ClickPictureScreenState(ClickPictureScreenViewStates.UnInitialized)
    }

    override fun handleIntent(intent: ClickPictureScreenIntent) {
        when(intent){
            is ClickPictureScreenIntent.NavigateToAgeScreen -> {
                println("###### NavigateToAgeScreen ClickPictureScreenViewModel")
                sendNavEffect {
                    ClickPictureScreenNavEffect.NavigateToAgeScreen
                }
            }
        }
    }

    private fun renderClickPictureScreen(ageScreenDataModel: ClickPictureScreenDataModel) {
        emitViewState {
            copy(
                ageScreenViewState = ClickPictureScreenViewStates.LoadedData(
                    showLoader = false,
                    data = ageScreenDataModel,
                ),
            )
        }
    }

    fun emitLoading() {
        emitViewState {
            copy(
                ageScreenViewState = ClickPictureScreenViewStates.InitialLoading(
                    showLoader = true,
                ),
            )
        }
    }


    private fun progressLoader(visibility: Boolean) {
        _showLoader.value = visibility
    }
}