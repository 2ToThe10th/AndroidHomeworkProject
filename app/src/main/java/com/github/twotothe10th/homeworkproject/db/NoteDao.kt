package com.github.twotothe10th.homeworkproject.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT count(*) FROM note")
    fun getNoteCount(): Int

    fun IsEmpty() = getNoteCount() == 0

    class NoteToInsert(
        val description: String,
        val date: String,
        @ColumnInfo(name = "image_uri") val imageUri: String
    )

    @Insert(entity = Note::class)
    fun insert(note: NoteToInsert): Long

    fun insert(description: String, date: String, imageUri: String): Note {
        return Note(insert(NoteToInsert(description, date, imageUri)), description, date, imageUri)
    }

    @Query("SELECT * from note")
    fun getAll(): List<Note>
}