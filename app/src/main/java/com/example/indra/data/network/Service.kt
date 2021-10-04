package com.example.indra.data.network

import com.example.indra.data.model.MainMovieEntity
import com.example.indra.data.network.remote.RetrofitApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Service @Inject constructor(private val api:RetrofitApiClient) {

    suspend fun getMovies(): MainMovieEntity {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMovies()
            ///val response = api.getAllMovies(1,"f46b58478f489737ad5a4651a4b25079")
            response.body()!!
        }
    }
}