package com.mindstix.capabilities.database.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

/**
 * Class that provides type converters for Room database to handle non-primitive types.
 * This class is used to convert between List<String> and String for storing in the database.
 */
// @ProvidedTypeConverter
class Converters {

    /**
     * Converts a JSON string to a List<String>.
     * This method is used by Room to store a List<String> in the database as a JSON string.
     * @param value The JSON string to be converted.
     * @return A List<String> represented by the JSON string.
     */
    @TypeConverter
    fun stringToList(value: String?): List<String>? {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(value, type)
    }

    /**
     * Converts a List<String> to a JSON string.
     * This method is used by Room to retrieve a List<String> from the database stored as a JSON string.
     * @param value The List<String> to be converted.
     * @return A JSON string representing the List<String>.
     */
    @TypeConverter
    fun listToString(value: List<String>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
