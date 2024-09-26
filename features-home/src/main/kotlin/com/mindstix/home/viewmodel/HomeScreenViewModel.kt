package com.mindstix.home.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.mindstix.capabilities.database.entities.SkinAnalysisEntity
import com.mindstix.capabilities.database.entities.SkincareProductEntity
import com.mindstix.core.base.BaseViewModel
import com.mindstix.home.intent.HomeScreenIntent
import com.mindstix.home.intent.HomeScreenNavEffect
import com.mindstix.home.intent.HomeScreenState
import com.mindstix.home.intent.HomeScreenViewStates
import com.mindstix.home.model.HomeScreenDataModel
import com.mindstix.onboarding.usecases.SkinAnalysisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    val skinAnalysisUseCase: SkinAnalysisUseCase
) : BaseViewModel<HomeScreenIntent, HomeScreenState, HomeScreenNavEffect>() {

    private val _showLoader = mutableStateOf(false)
    val showLoader: MutableState<Boolean> = _showLoader

    // MutableState to hold the list of SkinAnalysisEntity
    var skinAnalysesState = mutableStateOf<List<SkinAnalysisEntity>>(emptyList())
        private set

    var skinRecommendedProduct = mutableStateOf<List<SkincareProductEntity>>(emptyList())
        private set

    override fun createInitialState(): HomeScreenState {
        return HomeScreenState(HomeScreenViewStates.UnInitialized)
    }

    override fun handleIntent(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.GetSkinAnalysisData -> {
                viewModelScope.launch {
                    try {
                        progressLoader(true)
                        val skinAnalyses =
                            skinAnalysisUseCase.getSkinAnalysisDataFromDB() // Await the result
                        skinAnalysesState.value = skinAnalyses
                        Log.d("SkinAnalyses", skinAnalyses.toString())  // Log the response
                    } catch (e: Exception) {
                        Log.e("Error", "Error fetching skin analyses", e)
                    } finally {
                        progressLoader(false)
                    }
                }
            }

            is HomeScreenIntent.GetRecommendedProducts -> {
                viewModelScope.launch {
                    try {
                        progressLoader(true)
                        val recommendedProduct =
                            skinAnalysisUseCase.getListOfRecommendedProduct() // Await the result
                        skinRecommendedProduct.value = recommendedProduct
                        Log.d(
                            "skin Recommended Product", recommendedProduct.toString()
                        )  // Log the response
                    } catch (e: Exception) {
                        Log.e("Error", "Error fetching skin analyses", e)
                    } finally {
                        progressLoader(false)
                    }
                }
            }
        }
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

    protected val handler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch(Dispatchers.Main) {
            ///show error on screen exception.message
            progressLoader(false)
        }
    }


    private fun progressLoader(visibility: Boolean) {
        _showLoader.value = visibility
    }
}