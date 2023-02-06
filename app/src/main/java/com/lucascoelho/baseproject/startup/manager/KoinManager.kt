package com.lucascoelho.baseproject.startup.manager

import android.content.Context
import com.lucascoelho.baseproject.common.di.getKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinManager(context: Context) {
    init {
        startKoin {
            androidContext(context)
            modules(modules = getKoinModules())
        }
    }
}
