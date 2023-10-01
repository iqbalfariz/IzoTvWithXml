package com.example.izotvwithxml.core.domain.repository

import com.example.izotvwithxml.core.data.Resource
import com.example.izotvwithxml.core.domain.model.TvSeries
import kotlinx.coroutines.flow.Flow

interface ITvSeriesRepository {

    fun getAllTvSeries(): Flow<Resource<List<TvSeries>>>

    fun getFavoriteTvSeries(): Flow<List<TvSeries>>

    fun setFavoriteTvSeries(tourism: TvSeries, state: Boolean)


}