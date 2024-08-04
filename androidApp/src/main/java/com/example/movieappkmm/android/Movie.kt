package com.example.movieappkmm.android

import android.app.Application
import com.example.movieappkmm.android.di.appModule
import com.example.movieappkmm.di.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}