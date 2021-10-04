package com.example.indra.presentation.movies

import com.example.indra.domain.usecase.response.MovieResponse

interface OnMoviesAdapterListener {

    fun onSelectMovie(movieResponse: MovieResponse)
}