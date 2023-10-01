package com.example.izotvwithxml.core.domain.usecase

import com.example.izotvwithxml.core.data.Resource
import com.example.izotvwithxml.core.domain.model.TvSeries
import com.example.izotvwithxml.core.domain.repository.ITvSeriesRepository
import kotlinx.coroutines.flow.Flow

class TvSeriesInteractor(private val tvSeriesRepository: ITvSeriesRepository): TvSeriesUseCase {
    override fun getAllTvSeries(): Flow<Resource<List<TvSeries>>> = tvSeriesRepository.getAllTvSeries()
    override fun getFavoriteTvSeries(): Flow<List<TvSeries>> = tvSeriesRepository.getFavoriteTvSeries()

    override fun setFavoriteTvSeries(tvSeries: TvSeries, state: Boolean) = tvSeriesRepository.setFavoriteTvSeries(tvSeries, state)
}