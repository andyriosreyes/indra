package com.example.indra.data.mapper

import com.example.indra.data.model.MainMovieEntity
import com.example.indra.data.model.MovieEntity
import com.example.indra.domain.usecase.response.MainMovieResponse
import com.example.indra.domain.usecase.response.MovieResponse

object MovieMapper {

    fun MainMovieEntity.toDomain() = MainMovieResponse(
        total_pages = total_pages,
        results = results.map { it.toDomain() }
    )

    private fun MovieEntity.toDomain() = MovieResponse(
        id = id,
        poster_path = poster_path,
        vote_average = vote_average,
        title = title,
        release_date = release_date,
        overview = overview
    )
}