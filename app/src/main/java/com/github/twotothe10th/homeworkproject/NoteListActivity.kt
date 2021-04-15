package com.github.twotothe10th.homeworkproject

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class NoteListActivity : AppCompatActivity(), NoteAdapter.Listener {
    companion object {
        private const val eps = 1e-6
    }

    private var spSizeWas = 0.toFloat()
    private val noteListAdapter = NoteAdapter()

    override fun onNoteClick(id: Int) {
        startActivity(NoteDetailedActivity.getIntent(this, id))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.setHasFixedSize(true)
        recyclerView.recycledViewPool.setMaxRecycledViews(0, 5)

        noteListAdapter.setListener(this)
        noteListAdapter.setNoteList((this.application as App).noteRepository.noteList)
        recyclerView.adapter = noteListAdapter

        spSizeWas = resources.displayMetrics.scaledDensity
    }

    override fun onResume() {
        super.onResume()

        val spSize = resources.displayMetrics.scaledDensity
        if (abs(spSize - spSizeWas) > eps) {
            noteListAdapter.notifyDataSetChanged()
            spSizeWas = spSize
        }
    }

}