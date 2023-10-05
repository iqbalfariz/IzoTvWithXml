package com.example.izotvwithxml.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.izotvwithxml.core.domain.usecase.TvSeriesUseCase

class FavoriteViewModel(tvSeriesUseCase: TvSeriesUseCase): ViewModel() {
    val favoriteTvSeries = tvSeriesUseCase.getFavoriteTvSeries().asLiveData()
}