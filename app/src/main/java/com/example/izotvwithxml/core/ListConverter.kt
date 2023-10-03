package com.example.izotvwithxml.core

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//class ListConverter {
//    @TypeConverter
//    fun fromInt(value: Int?): List<Int>? {
//        if (value == null){
//            return null
//        }
//        val listType = object : TypeToken<List<Int>>() {}.type
//        return Gson().from
////        return Gson().fromJson(value, listType)
//    }
//}
