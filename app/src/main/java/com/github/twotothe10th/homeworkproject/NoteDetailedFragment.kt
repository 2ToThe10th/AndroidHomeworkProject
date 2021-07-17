package com.github.twotothe10th.homeworkproject

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.github.twotothe10th.homeworkproject.db.Note
import kotlin.math.round

class NoteDetailedFragment : Fragment() {

    companion object {
        const val TAG = "NoteDetailedFragment"
        private const val ID_KEY = "ID_KEY"
        fun newInstance(id: Long): NoteDetailedFragment {
            val fragment = NoteDetailedFragment()

            val arguments = Bundle()
            arguments.putLong(ID_KEY, id)
            fragment.arguments = arguments

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_detailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getLong(ID_KEY) ?: 0
        val note = (activity?.application as App).noteRepository.get(id)
            ?: throw IllegalStateException("note not found")
        val description = view.findViewById<TextView>(R.id.detailed_description)
        description.text = note.description
        val imageView = view.findViewById<ImageView>(R.id.detailed_photo)
        imageView.transitionName = "image_detailed$id"

        view.post {
            val (imageHeight, imageWidth) = getImageSize(view)
            Glide.with(this).load(Uri.parse(note.imageUri)).override(imageWidth, imageHeight)
                .into(imageView)
        }
    }

    private fun getImageSize(view: View): Pair<Int, Int> {
        return if (resources.getBoolean(R.bool.is_portrait)) {
            Pair(round(view.height * (3.0 / 5)).toInt(), view.width)
        } else {
            Pair(view.height, round(view.width * (3.0 / 5)).toInt())
        }
    }
}