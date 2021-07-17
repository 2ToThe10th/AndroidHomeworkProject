package com.github.twotothe10th.homeworkproject

import android.app.Application
import androidx.room.Room
import com.github.twotothe10th.homeworkproject.db.AppDatabase
import com.github.twotothe10th.homeworkproject.db.NoteRepository
import kotlinx.coroutines.*

class App : Application() {
    val noteRepository: NoteRepository = NoteRepository()

    override fun onCreate() {
        (MainScope() + CoroutineName("ApplicationCoroutine")).launch {
            super.onCreate()

            val db = withContext(Dispatchers.IO) {
                Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "note-database"
                ).build()
            }
            noteRepository.setDatabase(db)
        }
    }
}