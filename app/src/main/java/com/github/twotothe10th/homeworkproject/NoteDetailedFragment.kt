package com.github.twotothe10th.homeworkproject

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class NoteDetailedFragment : Fragment() {

    companion object {
        const val TAG = "NoteDetailedFragment"
        private const val ID_KEY = "ID_KEY"
        fun newInstance(id: Int): NoteDetailedFragment {
            val fragment = NoteDetailedFragment()

            val arguments = Bundle()
            arguments.putInt(ID_KEY, id)
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
        val id = arguments?.getInt(ID_KEY) ?: 0
        val note = (activity?.application as App).noteRepository.get(id)
        val description = view.findViewById<TextView>(R.id.detailed_description)
        description.text = note?.description
        val imageView = view.findViewById<ImageView>(R.id.detailed_photo)
        imageView.setImageURI(note?.imageUri)
        imageView.transitionName = "image_detailed$id"
    }
}