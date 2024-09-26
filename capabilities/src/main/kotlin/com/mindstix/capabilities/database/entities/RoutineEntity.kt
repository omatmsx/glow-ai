package com.mindstix.capabilities.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mindstix.capabilities.database.utils.ROUTINE_TABLE
import com.mindstix.core.utils.EMPTY_STRING

@Entity(
    tableName = ROUTINE_TABLE,
    indices = [Index(value = ["id"], unique = true)],
)
data class RoutineEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "task")
    var task: String? = EMPTY_STRING,

    @ColumnInfo(name = "time")
    var time: String? = EMPTY_STRING,

    @ColumnInfo(name = "reason")
    var reason: String? = EMPTY_STRING,
)
