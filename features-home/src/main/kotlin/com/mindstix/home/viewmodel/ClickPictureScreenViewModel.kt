package com.mindstix.home.viewmodel

import android.os.Message
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
        when (intent) {
            is ClickPictureScreenIntent.NavigateToAgeScreen -> {
                viewModelScope.launch(handler) {
                    progressLoader(true)
                    emitLoading("Analysing your Face")
                    val response = skinAnalysisUseCase.getSkinAnalysis(intent.imagePath)

                    emitLoading("Generating Skin care routine for you")
                    skinAnalysisUseCase.getSkinCare(response)

                    emitLoading("Fetching best make up products for your skin type")
                    skinAnalysisUseCase.getRecommendedMakeUpProducts(response)

                    emitLoading("Fetching suited products to make your skin glow")
                    skinAnalysisUseCase.getRecommendedProducts(response)

                    progressLoader(false)

                    sendNavEffect {
                        ClickPictureScreenNavEffect.NavigateToAgeScreen
                    }

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

    fun emitLoading(message: String) {
        emitViewState {
            copy(
                ageScreenViewState = ClickPictureScreenViewStates.InitialLoading(
                    showLoader = true,
                    message = message
                ),
            )
        }
    }

    private fun progressLoader(visibility: Boolean) {
        _showLoader.value = visibility
    }



    protected val handler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch(Dispatchers.Main) {
            emitViewState {
                copy(
                    ageScreenViewState = ClickPictureScreenViewStates.ErrorState(
                        message = exception.message?:"Something went wrong" // New error message state
                    )
                )
            }
            ///show error on screen exception.message
            progressLoader(false)
        }
    }
}