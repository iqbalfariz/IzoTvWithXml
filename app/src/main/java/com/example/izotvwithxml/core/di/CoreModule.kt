package com.example.izotvwithxml.core.di

import androidx.room.Room
import com.example.izotvwithxml.core.data.TvSeriesRepository
import com.example.izotvwithxml.core.data.source.local.LocalDataSource
import com.example.izotvwithxml.core.data.source.local.room.TvSeriesDatabase
import com.example.izotvwithxml.core.data.source.remote.RemoteDataSource
import com.example.izotvwithxml.core.data.source.remote.network.ApiService
import com.example.izotvwithxml.core.domain.repository.ITvSeriesRepository
import com.example.izotvwithxml.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<TvSeriesDatabase>().tvSeriesDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            TvSeriesDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ITvSeriesRepository> { TvSeriesRepository(get(), get(), get()) }
}
