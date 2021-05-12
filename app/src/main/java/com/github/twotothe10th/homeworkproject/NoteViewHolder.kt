package com.github.twotothe10th.homeworkproject

import java.text.SimpleDateFormat
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.github.twotothe10th.homeworkproject.db.Note
import com.squareup.picasso.Picasso
import java.util.Locale
import java.util.Date


class NoteViewHolder(noteView: View, noteListener: NoteAdapter.Listener?) : ViewHolder(noteView) {
    private var id: Long = 0
    private val descriptionView: TextView = noteView.findViewById(R.id.item_description)
    private val dateView: TextView = noteView.findViewById(R.id.item_date)
    private val imageView: ImageView = noteView.findViewById(R.id.item_image)
    private val dateFormatter = SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)

    fun bind(note: Note) {
        descriptionView.text = note.description
        dateView.text = dateFormatter.format(Date(note.date))
        id = note.id
        Picasso.get().load(Uri.parse(note.imageUri)).fit().centerCrop().into(imageView)
        imageView.transitionName = "image_list$id"
    }

    init {
        descriptionView.maxLines = descriptionView.layoutParams.height / descriptionView.lineHeight
        noteView.setOnClickListener { noteListener?.onNoteClick(id, imageView) }
    }
}