package com.example.movieappkmm.util

import com.example.movieappkmm.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(getSharedModules())
    }
}