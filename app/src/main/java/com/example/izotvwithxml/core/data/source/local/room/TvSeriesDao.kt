package com.example.izotvwithxml.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.izotvwithxml.core.data.source.local.entity.TvSeriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvSeriesDao {

    @Query("SELECT * FROM tvSeries")
    fun getAllTvSeries(): Flow<List<TvSeriesEntity>>

    @Query("SELECT * FROM tvSeries where isFavorite = 1")
    fun getFavoriteTvSeries(): Flow<List<TvSeriesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvSeries(tvSeries: List<TvSeriesEntity>)

    @Update
    fun updateFavoriteTvSeries(tvSeries: TvSeriesEntity)
}