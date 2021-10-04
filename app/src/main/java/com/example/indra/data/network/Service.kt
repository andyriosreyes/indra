package com.example.indra.data.network

import com.example.indra.data.model.MainMovieEntity
import com.example.indra.data.network.remote.RetrofitApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Service @Inject constructor(private val api:RetrofitApiClient) {

    suspend fun getMovies(page : Int,api_key : String): MainMovieEntity {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMovies(page,api_key)
            response.body()!!
        }
    }
}