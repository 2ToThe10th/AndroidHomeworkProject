package com.github.twotothe10th.homeworkproject

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class NoteViewHolder(noteView: View, noteListener: NoteAdapter.Listener?) : ViewHolder(noteView) {
    private var id: Int = 0
    private val descriptionView: TextView
    private val dateView: TextView
    private val imageView: ImageView

    fun bind(note: Note) {
        descriptionView.text = note.description
        dateView.text = note.date
        id = note.id
        imageView.setImageURI(note.imageUri)
    }

    init {
        noteView.setOnClickListener { noteListener?.onNoteClick(id) }
        descriptionView = noteView.findViewById(R.id.item_description)
        descriptionView.maxLines = descriptionView.layoutParams.height / descriptionView.lineHeight
        dateView = noteView.findViewById(R.id.item_date)
        imageView = noteView.findViewById(R.id.item_image)
    }
}