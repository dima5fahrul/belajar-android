package com.example.belajarandroid.local_data_persistent.data_sqlite.helper

import android.database.Cursor
import com.example.belajarandroid.local_data_persistent.data_sqlite.db.DatabaseContract
import com.example.belajarandroid.local_data_persistent.data_sqlite.entity.Note

object MappingHelper {
    private val dbContract = DatabaseContract.NoteColumns

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()
        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(dbContract._ID))
                val title = getString(getColumnIndexOrThrow(dbContract.TITLE))
                val description = getString(getColumnIndexOrThrow(dbContract.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(dbContract.DATE))
                notesList.add(Note(id, title, description, date))
            }
        }
        return notesList
    }
}