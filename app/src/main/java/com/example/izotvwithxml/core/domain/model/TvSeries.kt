package com.example.izotvwithxml.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvSeries(
    val tvSeriesId: Int,
    val backdropPath: String,
    val firstAirDate: String,
    val genreIds: List<Int>,
    val name: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val originalName: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val voteAverage: Double,
    val voteCount: Int,
    val isFavorite: Boolean = false
): Parcelable