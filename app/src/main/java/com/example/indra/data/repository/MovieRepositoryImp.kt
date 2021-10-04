package com.example.indra.data.repository

import com.example.indra.data.mapper.MovieMapper.toDomain
import com.example.indra.data.network.Service
import com.example.indra.data.network.local.DataBase
import com.example.indra.domain.usecase.response.MainMovieResponse
import com.example.indra.domain.usecase.response.MovieResponse
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val api: Service,
    private val database: DataBase
) {

    suspend fun getAllMoviesRepository() : MainMovieResponse{
        val response = api.getMovies()
        return response.toDomain()
    }

    fun addArticlesDAO(articles: List<MovieResponse>) {
        database.movieDAO.insertAll(articles)
    }

    fun getAllArticlesDAO(): List<MovieResponse> {
        return database.movieDAO.loadListMovieAll()
    }
}