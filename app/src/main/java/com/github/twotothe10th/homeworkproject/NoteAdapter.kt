package com.github.twotothe10th.homeworkproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {
    interface Listener {
        fun onNoteClick(id: Int)
    }

    private var noteList = emptyList<Note>()
    fun setNoteList(noteList: List<Note>) {
        this.noteList = noteList
        notifyDataSetChanged()
    }

    private var listener: Listener? = null
    fun setListener(listener: Listener?) {
        this.listener = listener
    }

    override fun getItemCount() = noteList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(
            R.layout.note_list_item,
            parent,
            false
        )
        return NoteViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }
}