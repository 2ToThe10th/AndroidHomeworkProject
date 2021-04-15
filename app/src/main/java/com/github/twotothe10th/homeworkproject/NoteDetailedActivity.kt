package com.github.twotothe10th.homeworkproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoteDetailedActivity : AppCompatActivity() {

    companion object {
        private const val ID_KEY = "ID_KEY"
        fun getIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, NoteDetailedActivity::class.java)
            intent.putExtra(ID_KEY, id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detailed)
        val id = intent.getIntExtra(ID_KEY, -1)
        val note = (this.application as App).noteRepository.get(id)
        val description = findViewById<TextView>(R.id.detailed_description)
        description.text = note?.description
        val photo = findViewById<ImageView>(R.id.detailed_photo)
        photo.setImageURI(note?.imageUri)
    }
}