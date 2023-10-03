package com.example.izotvwithxml.di

import com.example.izotvwithxml.core.domain.usecase.TvSeriesInteractor
import com.example.izotvwithxml.core.domain.usecase.TvSeriesUseCase
import com.example.izotvwithxml.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TvSeriesUseCase> { TvSeriesInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
//    viewModel { HomeViewModel(get()) }
//    viewModel { FavoriteViewModel(get()) }
//    viewModel { DetailTourismViewModel(get()) }
}