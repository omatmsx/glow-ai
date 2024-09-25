package com.mindstix.capabilities.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mindstix.capabilities.database.utils.USER_TABLE

@Entity(
    tableName = USER_TABLE,
    indices = [Index(value = ["id"], unique = true)],
)
data class UserDataEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "age")
    var age: Int? = null,

)
