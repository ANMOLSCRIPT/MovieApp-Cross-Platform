package com.example.movieappkmm.data.remote

import com.example.movieappkmm.data.remote.data.remote.MovieRemote
import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesResponse(
    val results: List<MovieRemote>
)
