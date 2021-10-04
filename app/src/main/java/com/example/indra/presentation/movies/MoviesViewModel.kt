package com.example.indra.presentation.movies

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indra.domain.usecase.GetAllMoviesUseCase
import com.example.indra.domain.usecase.response.MovieResponse
import com.example.indra.util.isConnected
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getAllMoviesUseCase: GetAllMoviesUseCase
) : ViewModel() {

    val movieLiveData = MutableLiveData<List<MovieResponse>>()

    fun allMovies(context: Context,page : Int, api_key : String) {
        viewModelScope.launch {
            runCatching {
                getAllMoviesUseCase(page,api_key)
            }.onSuccess {
                getAllMoviesUseCase.addArticlesDAO(it.results)
                movieLiveData.value = getAllMoviesUseCase.allArticlesDAO()
            }.onFailure {
                movieLiveData.value = getAllMoviesUseCase.allArticlesDAO()
            }
        }
    }
}