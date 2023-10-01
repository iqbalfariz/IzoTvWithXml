package com.example.izotvwithxml.core.data

import com.example.izotvwithxml.core.data.source.local.LocalDataSource
import com.example.izotvwithxml.core.data.source.remote.RemoteDataSource
import com.example.izotvwithxml.core.data.source.remote.network.ApiResponse
import com.example.izotvwithxml.core.data.source.remote.response.TvSeriesResponse
import com.example.izotvwithxml.core.domain.model.TvSeries
import com.example.izotvwithxml.core.domain.repository.ITvSeriesRepository
import com.example.izotvwithxml.core.utils.AppExecutors
import com.example.izotvwithxml.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TvSeriesRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): ITvSeriesRepository {
    override fun getAllTvSeries(): Flow<Resource<List<TvSeries>>> =
        object : NetworkBoundResource<List<TvSeries>, List<TvSeriesResponse>>(){
            override fun loadFromDB(): Flow<List<TvSeries>> {
                return localDataSource.getAllTvSeries().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<TvSeriesResponse>>> = remoteDataSource.getAllTvSeries()

            override suspend fun saveCallResult(data: List<TvSeriesResponse>) {
                val tvSeriesList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTvSeries(tvSeriesList)
            }

            override fun shouldFetch(data: List<TvSeries>?): Boolean = true
        }.asFlow()
    override fun getFavoriteTvSeries(): Flow<List<TvSeries>> {
        return localDataSource.getFavoriteTvSeries().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTvSeries(tvSeries: TvSeries, state: Boolean) {
        val tvSeriesEntity = DataMapper.mapDomainToEntity(tvSeries)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvSeries(tvSeriesEntity, state) }
    }


}