package com.github.twotothe10th.homeworkproject

import android.app.Application

class App : Application() {
    val noteRepository = NoteRepository()
}