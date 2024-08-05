package com.example.movieappkmm.data.remote

import com.example.movieappkmm.data.remote.data.remote.MovieRemote
import io.ktor.client.call.*
import io.ktor.client.request.*

internal class MovieService : KtorApi() {

    suspend fun getMovies(page: Int = 1): MoviesResponse {
        return try {
            client.get {
                pathUrl("movie/popular")
                parameter("page", page)
            }.body()
        } catch (e: Exception) {
            // Log the error
            println("Error fetching movies: ${e.message}")
            throw e
        }
    }

    suspend fun getMovie(movieId: Int): MovieRemote {
        return try {
            client.get {
                pathUrl("movie/${movieId}")
            }.body()
        } catch (e: Exception) {
            // Log the error
            println("Error fetching movie: ${e.message}")
            throw e
        }
    }
}
