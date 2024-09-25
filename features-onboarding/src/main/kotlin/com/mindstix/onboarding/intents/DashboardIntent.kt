/**
 * Copyright (c) 2023 Mindstix Software Labs
 * All rights reserved.
 */

package com.mindstix.onboarding.intents

import com.mindstix.core.base.NavEffect
import com.mindstix.core.base.UserIntent
import com.mindstix.core.base.ViewState
import com.mindstix.onboarding.models.DashboardScreenDataModel
import com.mindstix.onboarding.models.LoginScreenDataModel
import com.mindstix.onboarding.models.OfflineScreenDataModel

/**
 * Sealed class representing user intents for the login feature.
 *
 * @author Abhijeet Kokane
 */
sealed class DashboardIntent : UserIntent {
    object FetchDashboardIntentData : DashboardIntent()
    object NavigateToHomeScreen : DashboardIntent()
    object FetchDashboardData : DashboardIntent()
}

/**
 * Sealed class representing navigation effects for the login feature.
 *
 * @author Abhijeet Kokane
 */
sealed class DashboardNavEffect : NavEffect {
    object CloseDashboardNavEffectScreen : DashboardNavEffect()
}

/**
 * Sealed class representing different view states for the login feature.
 *
 * @author Abhijeet Kokane
 */
sealed class DashboardViewStates {
    data class LoadedData(
        val data: DashboardScreenDataModel,
    ) : DashboardViewStates()

    object InitialLoading : DashboardViewStates()

    object UnInitialized : DashboardViewStates()
}

/**
 * Data class representing the overall view state for the login feature.
 *
 * @param loginViewState The specific login view state.
 */
data class DashboardViewState(
    var DashboardViewStateViewState: DashboardViewStates,
) : ViewState
