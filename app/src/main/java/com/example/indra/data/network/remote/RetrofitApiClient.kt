package com.example.indra.data.network.remote

import com.example.indra.data.model.MainMovieEntity
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApiClient {
    @GET("upcoming?page=1&api_key=f46b58478f489737ad5a4651a4b25079")
    suspend fun getAllMovies(): Response<MainMovieEntity>

//    fun getAllMovies(
//        @Query("page") int: Int,
//        @Query("api_key") string: String): Response<List<MovieModel>>
}