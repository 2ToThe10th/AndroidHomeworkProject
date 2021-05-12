package com.github.twotothe10th.homeworkproject

import android.os.Bundle
import android.transition.Fade
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.MainScope

class MainActivity : AppCompatActivity(), NoteAdapter.Listener {

    private var detailedFragmentId: Int = 0

    override fun onNoteClick(id: Long, imageView: ImageView) {
        if (supportFragmentManager.findFragmentByTag(NoteDetailedFragment.TAG) != null) {
            supportFragmentManager.popBackStack()
        }

        val noteDetailedFragment = NoteDetailedFragment.newInstance(id)

        val transaction = supportFragmentManager
            .beginTransaction()

        if (!resources.getBoolean(R.bool.is_pad)) {
            noteDetailedFragment.sharedElementEnterTransition = DetailsTransition()
            noteDetailedFragment.sharedElementReturnTransition = DetailsTransition()
            transaction.addSharedElement(imageView, "image_detailed$id")
        }

        noteDetailedFragment.enterTransition = Fade()

        transaction.replace(
            detailedFragmentId,
            noteDetailedFragment,
            NoteDetailedFragment.TAG
        )
            .addToBackStack(null)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        detailedFragmentId = if (resources.getBoolean(R.bool.is_pad)) {
            R.id.detailed_container
        } else {
            R.id.main_container
        }

        val noteListFragment = NoteListFragment.newInstance()
        noteListFragment.exitTransition = Fade()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, noteListFragment, NoteListFragment.TAG)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}