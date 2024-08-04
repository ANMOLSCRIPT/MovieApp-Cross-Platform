package com.example.movieappkmm.di

import com.example.movieappkmm.data.remote.MovieService
import com.example.movieappkmm.data.remote.RemoteDataSource
import com.example.movieappkmm.data.repository.MovieRepositoryImpl
import com.example.movieappkmm.domain.repository.MovieRepository
import com.example.movieappkmm.domain.usecase.GetMovieUseCase
import com.example.movieappkmm.domain.usecase.GetMoviesUseCase
import com.example.movieappkmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules