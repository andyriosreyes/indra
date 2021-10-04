package com.example.indra.presentation.movies

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.indra.databinding.ItemMovieBinding
import com.example.indra.domain.usecase.response.MovieResponse
import com.example.indra.util.Constants
import java.util.*

class MoviesAdapter(val onMoviesAdapterListener: OnMoviesAdapterListener,val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val listMovie: MutableList<MovieResponse> = ArrayList()
    private val contextMain : Context ?= context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            // Inflate the layout for this fragment
            val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (contextMain != null) {
            (holder as MovieViewHolder).onBind(contextMain,getItem(position),)
        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    private fun getItem(position: Int): MovieResponse {
        return listMovie[position]
    }

    fun addData(list: List<MovieResponse>) {
        this.listMovie.addAll(list)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val itemBinding: ItemMovieBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(context : Context,movieResponse: MovieResponse) {
            val ruta = Constants.BASE_IMG_URL + movieResponse.poster_path
            Glide.with(context)
                .load(ruta)
                .into(itemBinding.ivMovie)

//            itemBinding.tvMovieTitle.text = movieResponse.title
//            itemBinding.tvMoviePoint.text = movieResponse.vote_average
//            itemBinding.tvMovieDate.text = movieResponse.release_date
//            itemBinding.tvMovieResumed.text = movieResponse.overview
            itemBinding.itemMovieCL.setOnClickListener {
                onMoviesAdapterListener.onSelectMovie(movieResponse)
            }
        }
    }

}