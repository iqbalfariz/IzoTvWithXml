package com.example.izotvwithxml.core.data.source.remote

import android.util.Log
import com.example.izotvwithxml.core.data.source.remote.network.ApiResponse
import com.example.izotvwithxml.core.data.source.remote.network.ApiService
import com.example.izotvwithxml.core.data.source.remote.response.TvSeriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllTvSeries(): Flow<ApiResponse<List<TvSeriesResponse>>> {
        return flow {
            try {
                val response = apiService.getPopularTvShows("en-US", 1)
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}