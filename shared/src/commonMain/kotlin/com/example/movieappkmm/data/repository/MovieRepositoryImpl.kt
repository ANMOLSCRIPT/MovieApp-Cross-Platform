package com.example.movieappkmm.data.repository

import com.example.movieappkmm.data.remote.RemoteDataSource
import com.example.movieappkmm.domain.model.Movie
import com.example.movieappkmm.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page)
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId)
    }
}