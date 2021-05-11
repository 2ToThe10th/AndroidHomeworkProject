package com.github.twotothe10th.homeworkproject

import android.app.Application
import androidx.room.Room
import com.github.twotothe10th.homeworkproject.db.AppDatabase
import com.github.twotothe10th.homeworkproject.db.NoteRepository

class App : Application() {
    val noteRepository: NoteRepository = NoteRepository()

    override fun onCreate() {
        super.onCreate()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "note-database"
        )
            .allowMainThreadQueries() // TODO: delete in 8 hw
            .build()
        noteRepository.setDatabase(db)
    }
}