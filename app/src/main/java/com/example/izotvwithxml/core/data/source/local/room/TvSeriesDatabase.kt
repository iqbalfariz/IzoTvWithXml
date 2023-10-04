package com.example.izotvwithxml.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.izotvwithxml.core.data.source.local.ListConverter
import com.example.izotvwithxml.core.data.source.local.entity.TvSeriesEntity

@Database(entities = [TvSeriesEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class TvSeriesDatabase : RoomDatabase() {

    abstract fun tvSeriesDao(): TvSeriesDao

}