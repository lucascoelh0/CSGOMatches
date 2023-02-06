package com.lucascoelho.baseproject.datasource.common.di

import com.lucascoelho.baseproject.datasource.common.database.AppDatabaseFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseDI {
    val module = module {
        single {
            AppDatabaseFactory.build(androidContext())
        }

//        Dao injection example
//        single { get<AppDatabase>().exampleDao() }
    }
}
