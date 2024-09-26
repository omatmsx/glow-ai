package com.mindstix.home.model

import com.mindstix.capabilities.database.entities.SkinCareRoutineEntity
import com.mindstix.core.utils.DataStatus
import com.mindstix.core.utils.EMPTY_STRING


data class SkinCareRoutineScreenDataModel(
    val status: DataStatus = DataStatus.Empty,
    val title: String = EMPTY_STRING,
    val skinCareRoutineList: List<SkinCareRoutineEntity> = emptyList()
){
    companion object {
        val defaultValue = SkinCareRoutineScreenDataModel()
    }
}