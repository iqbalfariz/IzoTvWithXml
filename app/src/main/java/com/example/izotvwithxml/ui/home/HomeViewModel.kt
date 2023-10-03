package com.example.izotvwithxml.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.izotvwithxml.core.domain.usecase.TvSeriesUseCase

class HomeViewModel(tvSeriesUseCase: TvSeriesUseCase): ViewModel() {

    val tvSeries = tvSeriesUseCase.getAllTvSeries().asLiveData()

}