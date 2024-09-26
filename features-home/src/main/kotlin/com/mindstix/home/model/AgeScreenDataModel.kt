package com.mindstix.home.model

import com.mindstix.core.utils.DataStatus
import com.mindstix.core.utils.EMPTY_STRING

data class AgeScreenDataModel(
    val status: DataStatus = DataStatus.Empty,
    val title: String = EMPTY_STRING,
){
    companion object {
        val defaultValue = AgeScreenDataModel()
    }
}
