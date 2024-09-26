package com.mindstix.home.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.mindstix.capabilities.database.dao.SkinCareRoutineDao
import com.mindstix.capabilities.database.entities.SkinCareRoutineEntity
import com.mindstix.core.base.BaseViewModel
import com.mindstix.home.intent.SkinCareRoutineScreenIntent
import com.mindstix.home.intent.SkinCareRoutineScreenNavEffect
import com.mindstix.home.intent.SkinCareRoutineScreenState
import com.mindstix.home.intent.SkinCareRoutineScreenViewStates
import com.mindstix.home.model.SkinCareRoutineScreenDataModel
import com.mindstix.onboarding.usecases.SkinAnalysisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SkinCareRoutineScreenViewModel @Inject constructor(
    private val skinAnalysisUseCase : SkinAnalysisUseCase,
    private val skinCareRoutineDao: SkinCareRoutineDao
) : BaseViewModel<SkinCareRoutineScreenIntent, SkinCareRoutineScreenState, SkinCareRoutineScreenNavEffect>() {

    private var skinCareDataModel = SkinCareRoutineScreenDataModel()

    private val _showLoader = mutableStateOf(false)
    val showLoader: MutableState<Boolean> = _showLoader

    private val _skinCareRoutineList: MutableState<List<SkinCareRoutineEntity>?> = mutableStateOf(null)
    val skinCareRoutineList: MutableState<List<SkinCareRoutineEntity>?> = _skinCareRoutineList

    override fun createInitialState(): SkinCareRoutineScreenState {
        return SkinCareRoutineScreenState(SkinCareRoutineScreenViewStates.UnInitialized)
    }

    override fun handleIntent(intent: SkinCareRoutineScreenIntent) {
        when(intent){
            is SkinCareRoutineScreenIntent.GetSkinCareRoutineData -> {
                println("###### skinCareRoutines INTENT")
                viewModelScope.launch {
                    val skinCareRoutines = skinCareRoutineDao.getAllRoutines()
                    skinCareDataModel = skinCareDataModel.copy(
                        skinCareRoutineList = skinCareRoutines
                    )
                    renderSkinCareScreen(skinCareDataModel)
                }
            }
        }
    }

    private fun renderSkinCareScreen(ageScreenDataModel: SkinCareRoutineScreenDataModel) {
        emitViewState {
            copy(
                skinCareRoutineScreenViewState = SkinCareRoutineScreenViewStates.LoadedData(
                    showLoader = false,
                    data = ageScreenDataModel,
                ),
            )
        }
    }

    fun emitLoading() {
        emitViewState {
            copy(
                skinCareRoutineScreenViewState = SkinCareRoutineScreenViewStates.InitialLoading(
                    showLoader = true,
                ),
            )
        }
    }

    private fun progressLoader(visibility: Boolean) {
        _showLoader.value = visibility
    }
}