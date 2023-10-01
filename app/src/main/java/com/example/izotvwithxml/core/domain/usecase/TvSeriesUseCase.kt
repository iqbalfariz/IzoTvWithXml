package com.example.izotvwithxml.core.domain.usecase

import com.example.izotvwithxml.core.data.Resource
import com.example.izotvwithxml.core.domain.model.TvSeries
import kotlinx.coroutines.flow.Flow

interface TvSeriesUseCase {

    fun getAllTvSeries(): Flow<Resource<List<TvSeries>>>

    fun getFavoriteTvSeries(): Flow<List<TvSeries>>

    fun setFavoriteTvSeries(tvSeries: TvSeries, state: Boolean)

}