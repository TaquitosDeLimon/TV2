package com.example.ra.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ra.data.RetrofitServiceFactory
import com.example.ra.model.TMDBResult
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MoviesViewModel : ViewModel() {

    private val _movies = MutableStateFlow<TMDBResult?>(null)
    val movies: StateFlow<TMDBResult?> get() = _movies

    private val service = RetrofitServiceFactory.makeRetrofitService()

    fun fetchPopularMovies() {
        viewModelScope.launch {
            try {
                val result = service.listPopularMovies(
                    "es-MX",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzYTJiNDMxZTljNGVjMDBlZGY3NmY2MzljMmZiOGI5YiIsIm5iZiI6MTcyNDE3MjIyMS44OTM5MTEsInN1YiI6IjYzOTI4MThiZjA0ZDAxMDA4YzQxY2Y5YiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.55PtkJ13e9wZFcSHe3aUVIhaJLmHtz_LOTxQnfEa7DM",
                    "application/json"
                )
                _movies.value = result
            } catch (e: Exception) {
                _movies.value = null
            }
        }
    }
}
