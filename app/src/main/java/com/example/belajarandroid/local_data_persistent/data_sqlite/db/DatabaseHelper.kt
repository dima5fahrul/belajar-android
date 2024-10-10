package com.example.belajarandroid.local_data_persistent.data_sqlite.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "dbnoteapp"
        private const val DATABASE_VERSION = 1
        private val dbContract = DatabaseContract.NoteColumns

        private const val SQL_CREATE_TABLE_NOTE =
            "CREATE TABLE ${dbContract.TABLE_NAME}" +
                    " (${dbContract._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " ${dbContract.TITLE} TEXT NOT NULL," +
                    " ${dbContract.DESCRIPTION} TEXT NOT NULL," +
                    " ${dbContract.DATE} TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${dbContract.TABLE_NAME}")
        onCreate(db)
    }
}