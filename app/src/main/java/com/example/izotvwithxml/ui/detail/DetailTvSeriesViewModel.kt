package com.example.izotvwithxml.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.izotvwithxml.core.domain.model.TvSeries
import com.example.izotvwithxml.core.domain.usecase.TvSeriesUseCase

class DetailTvSeriesViewModel(private val tvSeriesUseCase: TvSeriesUseCase): ViewModel() {


    fun setFavoriteTvSeries(tvSeries: TvSeries, newStatus:Boolean) {
        Log.d("flow view model", "$newStatus")
        tvSeriesUseCase.setFavoriteTvSeries(tvSeries, newStatus)
    }

}