package com.example.izotvwithxml.core.data.source.remote.network

import com.example.izotvwithxml.core.data.source.remote.response.ListTvSeriesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("tv/popular")
    @Headers(
        ContentTypeConstant.CONTENT_TYPE_JSON,
        AuthKey.AUTHORIZATION
    )
    fun getPopularTvShows(
        @Query("language") language: String,
        @Query("page") page: Int
    ): ListTvSeriesResponse

}