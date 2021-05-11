package com.github.twotothe10th.homeworkproject.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT count(*) FROM note")
    fun getNoteCount(): Long

    fun IsEmpty() = getNoteCount() == 0L

    class NoteToInsert(
        val description: String,
        val date: Long,
        @ColumnInfo(name = "image_uri") val imageUri: String
    )

    @Insert(entity = Note::class)
    fun insert(note: NoteToInsert): Long

    fun insert(description: String, date: Long, imageUri: String): Note {
        return Note(insert(NoteToInsert(description, date, imageUri)), description, date, imageUri)
    }

    @Query("SELECT * from note")
    fun getAll(): List<Note>
}