package com.github.twotothe10th.homeworkproject.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT count(*) FROM note")
    suspend fun getNoteCount(): Long

    suspend fun IsEmpty() = getNoteCount() == 0L

    class NoteToInsert(
        val description: String,
        val date: Long,
        @ColumnInfo(name = "image_uri") val imageUri: String
    )

    @Insert(entity = Note::class)
    suspend fun insert(note: NoteToInsert): Long

    suspend fun insert(description: String, date: Long, imageUri: String): Note {
        return Note(insert(NoteToInsert(description, date, imageUri)), description, date, imageUri)
    }

    @Query("SELECT * from note")
    suspend fun getAll(): List<Note>
}