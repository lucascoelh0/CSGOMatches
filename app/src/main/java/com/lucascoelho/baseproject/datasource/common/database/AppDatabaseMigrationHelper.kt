package com.lucascoelho.baseproject.datasource.common.database

import android.database.Cursor
import android.database.sqlite.SQLiteException
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

internal object AppDatabaseMigrationHelper {

//    Migration example
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
        }
    }

    private fun isFieldExist(db: SupportSQLiteDatabase, tableName: String, fieldName: String?): Boolean {
        var res: Cursor? = null
        return try {
            res = db.query("SELECT * FROM $tableName limit 1", emptyArray())
            val colIndex: Int = res.getColumnIndex(fieldName)
            colIndex != -1
        } catch (e: SQLiteException) {
            false
        } finally {
            res?.close()
        }
    }
}
