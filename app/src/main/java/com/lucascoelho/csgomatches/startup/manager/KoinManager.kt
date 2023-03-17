package com.lucascoelho.csgomatches.startup.manager

import android.content.Context
import com.lucascoelho.csgomatches.common.di.getKoinModules
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
