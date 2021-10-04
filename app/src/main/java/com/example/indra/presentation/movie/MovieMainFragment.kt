package com.example.indra.presentation.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.indra.R
import com.example.indra.databinding.FragmentMovieMainBinding
import com.example.indra.databinding.FragmentMoviesBinding
import com.example.indra.domain.usecase.response.MainMovieResponse
import com.example.indra.domain.usecase.response.MovieResponse
import com.example.indra.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieMainFragment : Fragment() {
    private lateinit var binding: FragmentMovieMainBinding
    private val args : MovieMainFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieResponse = args.movieResponse
        setUpMovie(movieResponse)

    }

    fun setUpMovie(movieResponse: MovieResponse){
        val ruta = Constants.BASE_IMG_URL + movieResponse.poster_path
        Glide.with(requireContext())
            .load(ruta)
            .into(binding.ivMovieMain)

        binding.tvMovieTitle.text = movieResponse.title
        binding.tvMovieDate.text = movieResponse.release_date
        binding.tvMoviePoint.text = movieResponse.vote_average
        binding.tvMovieResumed.text = movieResponse.overview
    }
}