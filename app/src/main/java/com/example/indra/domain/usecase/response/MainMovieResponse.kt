package com.example.indra.domain.usecase.response

data class MainMovieResponse(
    val total_pages: Int,
    val results: List<MovieResponse>) {
}