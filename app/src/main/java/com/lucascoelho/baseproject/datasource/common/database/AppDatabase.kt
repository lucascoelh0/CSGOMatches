package com.lucascoelho.baseproject.datasource.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucascoelho.baseproject.examplemodule.entity.ExampleEntity

@Database(
    entities = [
        ExampleEntity::class
    ],
    version = AppDatabase.VERSION,
    exportSchema = true
)
internal abstract class AppDatabase : RoomDatabase() {

//    Dao example
//    abstract fun exampleDao(): ExampleDao

    companion object {
        const val VERSION = 1
        const val FILE_NAME = "DATABASE"
    }
}
