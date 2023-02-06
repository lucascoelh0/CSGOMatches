package com.lucascoelho.baseproject.datasource.common.database

import android.content.Context
import androidx.room.Room

internal object AppDatabaseFactory {

    fun build(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.FILE_NAME)
//            .addMigrations(AppDatabaseMigrationHelper.MIGRATION_1_2)
            .build()
    }
}
