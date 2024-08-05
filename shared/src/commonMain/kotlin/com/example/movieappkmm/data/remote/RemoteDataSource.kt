package com.example.movieappkmm.data.remote

import com.example.movieappkmm.data.util.toMovie
import com.example.movieappkmm.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
) {

    suspend fun getMovies(page: Int) = withContext(dispatcher.io){
        apiService.getMovies(page = page).results.map { it.toMovie() }
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io){
        apiService.getMovie(movieId = movieId).toMovie()
    }
}