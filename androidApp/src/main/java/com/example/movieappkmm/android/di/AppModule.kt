package com.example.movieappkmm.android.di

import com.example.movieappkmm.android.detail.DetailViewModel
import com.example.movieappkmm.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(), movieId = params.get()) }
}