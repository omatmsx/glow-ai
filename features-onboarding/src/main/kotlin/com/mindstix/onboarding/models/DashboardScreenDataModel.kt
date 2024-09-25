package com.mindstix.onboarding.models

import com.mindstix.core.utils.emptyValue

data class DashboardScreenDataModel(
    val skinAnalysisData:String=String.emptyValue(),
    val recommendedProducts:String=String.emptyValue(),
){
    companion object{
        fun defaultValue()=DashboardScreenDataModel()
    }
}