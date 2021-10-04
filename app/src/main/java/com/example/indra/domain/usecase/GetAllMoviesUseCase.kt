package com.example.indra.domain.usecase

import com.example.indra.data.model.MovieEntity
import com.example.indra.data.repository.MovieRepositoryImp
import com.example.indra.domain.usecase.response.MainMovieResponse
import com.example.indra.domain.usecase.response.MovieResponse
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleObserver
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MovieRepositoryImp) {

    suspend operator fun invoke() = repository.getAllMoviesRepository()

    fun addArticlesDAO(movies: List<MovieResponse>) {
        repository.addArticlesDAO(movies)
    }

    fun allArticlesDAO(): List<MovieResponse> {
        return repository.getAllArticlesDAO()
    }

}