package com.example.izotvwithxml.core.data.source.local

import android.util.Log
import com.example.izotvwithxml.core.data.source.local.entity.TvSeriesEntity
import com.example.izotvwithxml.core.data.source.local.room.TvSeriesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val tvSeriesDao: TvSeriesDao) {

    fun getAllTvSeries(): Flow<List<TvSeriesEntity>> = tvSeriesDao.getAllTvSeries()

    fun getFavoriteTvSeries(): Flow<List<TvSeriesEntity>> = tvSeriesDao.getFavoriteTvSeries()

    suspend fun insertTvSeries(tvSeriesList: List<TvSeriesEntity>) = tvSeriesDao.insertTvSeries(tvSeriesList)

    fun setFavoriteTvSeries(tvSeries: TvSeriesEntity, newState: Boolean){
        tvSeries.isFavorite = newState
        Log.d("result update is favorite", "${tvSeries}")
        tvSeriesDao.updateFavoriteTvSeries(tvSeries)
    }
}