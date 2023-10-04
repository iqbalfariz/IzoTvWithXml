package com.example.izotvwithxml.core.data.source.local

import androidx.room.TypeConverter

class ListConverter {

    @TypeConverter
    fun fromIntList(list: List<Int>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun toIntList(data: String?): List<Int>? {
        return data?.split(",")?.mapNotNull { it.toIntOrNull() }
    }

    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        return list?.joinToString(",")
    }

    @TypeConverter
    fun toStringList(data: String?): List<String>? {
        return data?.split(",")
    }

}