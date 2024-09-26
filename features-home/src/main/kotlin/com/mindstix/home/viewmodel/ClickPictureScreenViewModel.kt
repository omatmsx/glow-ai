package com.mindstix.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.mindstix.core.base.BaseViewModel
import com.mindstix.home.intent.ClickPictureScreenIntent
import com.mindstix.home.intent.ClickPictureScreenNavEffect
import com.mindstix.home.intent.ClickPictureScreenState
import com.mindstix.home.intent.ClickPictureScreenViewStates
import com.mindstix.home.model.ClickPictureScreenDataModel
import com.mindstix.onboarding.usecases.SkinAnalysisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class ClickPictureScreenViewModel @Inject constructor(
    val skinAnalysisUseCase : SkinAnalysisUseCase
) : BaseViewModel<ClickPictureScreenIntent, ClickPictureScreenState, ClickPictureScreenNavEffect>() {

    private val _showLoader = mutableStateOf(false)
    val showLoader: MutableState<Boolean> = _showLoader

    override fun createInitialState(): ClickPictureScreenState {
        return ClickPictureScreenState(ClickPictureScreenViewStates.UnInitialized)
    }

    override fun handleIntent(intent: ClickPictureScreenIntent) {
        when(intent){
            is ClickPictureScreenIntent.NavigateToAgeScreen -> {
                viewModelScope.launch(handler) {

                    progressLoader(true)
                    val response = skinAnalysisUseCase.getSkinAnalysis(intent.imagePath)
                    progressLoader(false)
                    ClickPictureScreenNavEffect.NavigateToAgeScreen

                }
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



    protected val handler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch(Dispatchers.Main) {
            ///show error on screen exception.message
            progressLoader(false)
        }
    }
}