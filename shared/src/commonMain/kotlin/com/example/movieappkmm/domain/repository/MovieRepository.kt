package com.example.movieappkmm.domain.repository

import com.example.movieappkmm.domain.model.Movie

internal interface MovieRepository {

    suspend fun getMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: Int): Movie
}