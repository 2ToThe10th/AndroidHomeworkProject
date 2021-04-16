package com.github.twotothe10th.homeworkproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), NoteAdapter.Listener {
    override fun onNoteClick(id: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_container,
                NoteDetailedFragment.newInstance(id),
                NoteDetailedFragment.TAG
            )
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NoteListFragment.newInstance(), NoteListFragment.TAG)
                .addToBackStack(null)
                .commit()
        }
    }
}