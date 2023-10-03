package com.example.izotvwithxml.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.izotvwithxml.R
import com.example.izotvwithxml.core.domain.model.TvSeries
import com.example.izotvwithxml.databinding.ItemListTvSeriesBinding

class TvSeriesAdapter: RecyclerView.Adapter<TvSeriesAdapter.ListViewHolder>() {

    private var listData = ArrayList<TvSeries>()
    var onItemClick: ((TvSeries) -> Unit)? = null

    fun setData(newListData: List<TvSeries>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_tv_series, parent, false))

    override fun onBindViewHolder(holder: TvSeriesAdapter.ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTvSeriesBinding.bind(itemView)

        fun bind(data: TvSeries) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.posterPath)
                    .into(ivItemImage)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.overview
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }

    }
}