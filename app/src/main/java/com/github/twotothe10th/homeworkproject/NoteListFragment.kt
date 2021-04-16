package com.github.twotothe10th.homeworkproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class NoteListFragment : Fragment() {

    companion object {
        const val TAG = "NoteListFragment"
        private const val eps = 1e-6

        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }

    private var spSizeWas = 0.toFloat()
    private val noteListAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view)

        recyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)

        recyclerView.setHasFixedSize(true)
        recyclerView.recycledViewPool.setMaxRecycledViews(0, 5)

        noteListAdapter.setListener(activity as MainActivity)
        noteListAdapter.setNoteList((activity?.application as App).noteRepository.noteList)
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