package com.example.izotvwithxml.core.utils

import com.example.izotvwithxml.core.data.source.local.entity.TvSeriesEntity
import com.example.izotvwithxml.core.data.source.remote.response.TvSeriesResponse
import com.example.izotvwithxml.core.domain.model.TvSeries

object DataMapper {

    fun mapResponsesToEntities(input: List<TvSeriesResponse>): List<TvSeriesEntity> {
        val tvSeriesList = ArrayList<TvSeriesEntity>()
        input.map {
            val tvSeries = TvSeriesEntity(
                tvSeriesId = it.id,
                backdropPath = it.backdropPath,
                firstAirDate = it.firstAirDate,
                genreIds = it.genreIds,
                name = it.name,
                originCountry = it.originCountry,
                originalLanguage = it.originalLanguage,
                originalName = it.originalName,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = false
            )
            tvSeriesList.add(tvSeries)
        }
        return tvSeriesList
    }

    fun mapEntitiesToDomain(input: List<TvSeriesEntity>): List<TvSeries> =
        input.map {
            TvSeries(
                tvSeriesId = it.tvSeriesId,
                backdropPath = it.backdropPath,
                firstAirDate = it.firstAirDate,
                genreIds = it.genreIds,
                name = it.name,
                originCountry = it.originCountry,
                originalLanguage = it.originalLanguage,
                originalName = it.originalName,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = false
            )
        }

    fun mapDomainToEntity(it: TvSeries) = TvSeriesEntity(
        tvSeriesId = it.tvSeriesId,
        backdropPath = it.backdropPath,
        firstAirDate = it.firstAirDate,
        genreIds = it.genreIds,
        name = it.name,
        originCountry = it.originCountry,
        originalLanguage = it.originalLanguage,
        originalName = it.originalName,
        overview = it.overview,
        popularity = it.popularity,
        posterPath = it.posterPath,
        voteAverage = it.voteAverage,
        voteCount = it.voteCount,
        isFavorite = false
    )

}