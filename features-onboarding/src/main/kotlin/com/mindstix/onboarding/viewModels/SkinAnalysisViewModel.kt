package com.mindstix.onboarding.viewModels

import androidx.lifecycle.viewModelScope
import com.mindstix.core.base.BaseViewModel
import com.mindstix.onboarding.intents.DashboardIntent
import com.mindstix.onboarding.intents.DashboardNavEffect
import com.mindstix.onboarding.intents.DashboardViewState
import com.mindstix.onboarding.intents.DashboardViewStates
import com.mindstix.onboarding.models.DashboardScreenDataModel
import com.mindstix.onboarding.usecases.SkinAnalysisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject
constructor(
    private val skinAnalysisUseCase: SkinAnalysisUseCase
): BaseViewModel<DashboardIntent, DashboardViewState, DashboardNavEffect>() {
    override fun createInitialState(): DashboardViewState {
        return DashboardViewState(DashboardViewStates.LoadedData(DashboardScreenDataModel.defaultValue()))
    }

    override fun handleIntent(intent: DashboardIntent) {
        when (intent) {
            is DashboardIntent.NavigateToHomeScreen -> {

            }

            DashboardIntent.FetchDashboardIntentData -> {
                sendNavEffect {
                    DashboardNavEffect.CloseDashboardNavEffectScreen
                }
            }

            DashboardIntent.FetchDashboardData -> {
                fetchDashboardData()

            }
        }
    }

    private fun fetchDashboardData() {
        viewModelScope.launch(Dispatchers.IO) {
            val loginDataModel = skinAnalysisUseCase.getSkinAnalysis("")
        }
    }


}