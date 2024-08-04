package com.example.movieappkmm.data.remote

import com.example.movieappkmm.data.remote.data.remote.MovieRemote
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class MovieService: KtorApi() {

    suspend fun getMovies(page: Int = 1): MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(movieId: Int): MovieRemote = client.get {
        pathUrl("movie/${movieId}")
    }.body()
}