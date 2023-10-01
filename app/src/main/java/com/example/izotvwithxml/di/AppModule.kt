package com.example.izotvwithxml.di

import com.example.izotvwithxml.core.domain.usecase.TvSeriesInteractor
import com.example.izotvwithxml.core.domain.usecase.TvSeriesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<TvSeriesUseCase> { TvSeriesInteractor(get()) }
}

val viewModelModule = module {
//    viewModel { HomeViewModel(get()) }
//    viewModel { FavoriteViewModel(get()) }
//    viewModel { DetailTourismViewModel(get()) }
}