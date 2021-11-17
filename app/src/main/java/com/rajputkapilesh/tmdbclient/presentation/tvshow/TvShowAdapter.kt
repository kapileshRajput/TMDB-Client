package com.rajputkapilesh.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rajputkapilesh.tmdbclient.R
import com.rajputkapilesh.tmdbclient.data.model.tvshow.TvShow
import com.rajputkapilesh.tmdbclient.databinding.ListItemBinding

class TvShowAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: ArrayList<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }
}

class MyViewHolder(val binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow) {
        binding.apply {
            titleTextView.text = tvShow.name
            descriptionTextView.text = tvShow.overview
            val posterUrl = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}"
            Glide.with(imageView.context)
                .load(posterUrl)
                .into(imageView)
        }
    }
}