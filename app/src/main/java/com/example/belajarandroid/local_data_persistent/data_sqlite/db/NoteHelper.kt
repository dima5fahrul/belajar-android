package com.example.belajarandroid.local_data_persistent.data_sqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

class NoteHelper(context: Context) {
    private var databaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase
    private val dbContract = DatabaseContract.NoteColumns

    companion object {
        private const val DATABASE_TABLE = DatabaseContract.NoteColumns.TABLE_NAME
        private var INSTANCE: NoteHelper? = null
        fun getInstance(context: Context): NoteHelper = INSTANCE ?: synchronized(this) {
            INSTANCE ?: NoteHelper(context)
        }
    }

    @Throws(SQLException::class)
    fun open() {
        database = databaseHelper.writableDatabase
    }

    fun close() {
        databaseHelper.close()
        if (database.isOpen) database.close()
    }

    fun queryAll(): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "${dbContract._ID} ASC"
        )

    }

    fun queryById(id: String): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            "${dbContract._ID} = ?",
            arrayOf(id),
            null,
            null,
            null,
            null,
        )
    }

    fun insert(values: ContentValues?): Long {
        return database.insert(DATABASE_TABLE, null, values)
    }

    fun update(id: String, values: ContentValues?): Int {
        return database.update(
            DATABASE_TABLE,
            values,
            "${dbContract._ID} = ?",
            arrayOf(id)
        )
    }

    fun deleteById(id: String): Int {
        return database.delete(DATABASE_TABLE, "${dbContract._ID} = '$id'", null)
    }
}