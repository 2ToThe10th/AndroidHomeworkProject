package com.github.twotothe10th.homeworkproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.github.twotothe10th.homeworkproject.db.Note
import com.github.twotothe10th.homeworkproject.db.NoteRepository

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>(), NoteRepository.UpdateListener {
    interface Listener {
        fun onNoteClick(id: Long, imageView: ImageView? = null)
    }

    private var noteList = emptyList<Note>()
    override suspend fun setNoteList(noteList: List<Note>) {
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