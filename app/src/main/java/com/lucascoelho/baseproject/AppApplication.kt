package com.lucascoelho.baseproject

import android.app.Application
import android.util.Log
import androidx.work.Configuration

open class AppApplication : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setMinimumLoggingLevel(Log.INFO)
            .build()
    }
}
