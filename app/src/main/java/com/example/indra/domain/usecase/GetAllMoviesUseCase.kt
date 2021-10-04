package com.example.indra.domain.usecase

import com.example.indra.data.repository.MovieRepositoryImp
import com.example.indra.domain.usecase.response.MovieResponse
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private val repository: MovieRepositoryImp) {

    suspend operator fun invoke(page : Int, api_key : String) = repository.getAllMoviesRepository(page,api_key)

    fun addArticlesDAO(movies: List<MovieResponse>) {
        repository.addArticlesDAO(movies)
    }

    fun allArticlesDAO(): List<MovieResponse> {
        return repository.getAllArticlesDAO()
    }

}