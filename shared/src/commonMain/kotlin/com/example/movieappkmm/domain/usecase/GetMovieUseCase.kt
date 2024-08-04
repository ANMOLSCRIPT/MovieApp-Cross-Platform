package com.example.movieappkmm.domain.usecase

import com.example.movieappkmm.domain.model.Movie
import com.example.movieappkmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMovieUseCase: KoinComponent {
    private val repository: MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(movieId: Int): Movie{
        return repository.getMovie(movieId = movieId)
    }
}