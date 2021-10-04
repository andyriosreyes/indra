package com.example.indra.data.network.remote

import com.example.indra.data.model.MainMovieEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiClient {
    @GET("upcoming")
    suspend fun getAllMovies(
        @Query("page") page: Int,
        @Query("api_key") api_key: String): Response<MainMovieEntity>
}