package com.github.twotothe10th.homeworkproject

import android.net.Uri
import android.os.Bundle
import android.transition.Fade
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), NoteAdapter.Listener {

    private var detailedFragmentId: Int = 0
    private val mainScope = MainScope() + CoroutineName("MainActivity")

    override fun onNoteClick(id: Long, imageView: ImageView?) {
        if (supportFragmentManager.findFragmentByTag(NoteDetailedFragment.TAG) != null) {
            supportFragmentManager.popBackStack()
        }

        val noteDetailedFragment = NoteDetailedFragment.newInstance(id)

        val transaction = supportFragmentManager
            .beginTransaction()

        if (imageView != null && !resources.getBoolean(R.bool.is_pad)) {
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

    fun toPermissionCheckFragment() =
        changeFragment(
            CameraFragment.TAG,
            PermissionCheckFragment.newInstance(),
            PermissionCheckFragment.TAG
        )

    fun toCameraFragment() =
        changeFragment(
            PermissionCheckFragment.TAG,
            CameraFragment.newInstance(),
            CameraFragment.TAG
        )

    private fun changeFragment(fromTag: String, toFragment: Fragment, toTag: String) {
        if (supportFragmentManager.findFragmentByTag(fromTag) != null) {
            supportFragmentManager.popBackStack()
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, toFragment, toTag)
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

    fun onImageMade(imageUri: Uri) {
        if (supportFragmentManager.findFragmentByTag(CameraFragment.TAG) != null) {
            supportFragmentManager.popBackStack()
        }

        mainScope.launch {
            val image =
                withContext(Dispatchers.IO) {
                    InputImage.fromFilePath(applicationContext, imageUri)
                }
            val recognizer = TextRecognition.getClient()
            val result = recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    mainScope.launch {
                        val newId = (application as App).noteRepository.insertNote(
                            visionText.text,
                            System.currentTimeMillis(),
                            imageUri.toString()
                        )
                        onNoteClick(newId)
                    }
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, e.toString())
                    Toast.makeText(applicationContext, "text not recognized", Toast.LENGTH_LONG)
                        .show()
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mainScope.cancel()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        val TAG = "MainActivity"
    }
}