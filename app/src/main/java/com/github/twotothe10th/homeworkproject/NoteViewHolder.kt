package com.github.twotothe10th.homeworkproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class NoteViewHolder(noteView: View, noteListener: NoteAdapter.Listener?) : ViewHolder(noteView) {
    private var id: Int = 0
    private val descriptionView: TextView = noteView.findViewById(R.id.item_description)
    private val dateView: TextView = noteView.findViewById(R.id.item_date)
    private val imageView: ImageView = noteView.findViewById(R.id.item_image)

    fun bind(note: Note) {
        descriptionView.text = note.description
        dateView.text = note.date
        id = note.id
        imageView.setImageURI(note.imageUri)
        imageView.transitionName = "image_list$id"
    }

    init {
        descriptionView.maxLines = descriptionView.layoutParams.height / descriptionView.lineHeight
        noteView.setOnClickListener { noteListener?.onNoteClick(id, imageView) }
    }
}