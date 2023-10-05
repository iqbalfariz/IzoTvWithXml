package com.example.izotvwithxml.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.izotvwithxml.R
import com.example.izotvwithxml.core.domain.model.TvSeries
import com.example.izotvwithxml.databinding.ActivityDetailTvSeriesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTvSeriesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTvSeriesViewModel: DetailTvSeriesViewModel by viewModel()
    private lateinit var binding: ActivityDetailTvSeriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvSeriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailTvSeries = intent.getParcelableExtra<TvSeries>(EXTRA_DATA)
        showDetailTvSeries(detailTvSeries)

    }

    private fun showDetailTvSeries(detailTvSeries: TvSeries?) {
        detailTvSeries?.let {
            supportActionBar?.title = detailTvSeries.name
            binding.content.tvDetailDescription.text = detailTvSeries.overview
            val baseUrl = "https://image.tmdb.org/t/p/w500"
            Glide.with(this@DetailTvSeriesActivity)
                .load(baseUrl + detailTvSeries.posterPath)
                .into(binding.ivDetailImage)

            var statusFavorite = detailTvSeries.isFavorite
            Log.d("result favorite", "$statusFavorite")
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTvSeriesViewModel.setFavoriteTvSeries(detailTvSeries, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite){
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.unfavorite))
        }
    }
}