package com.app.gradhack

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File


class VideoViewActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var firebaseStorage: FirebaseStorage
    private lateinit var storageReference: StorageReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

//        storageReference = FirebaseStorage.getInstance().getReference()
//        val ref = storageReference.child("production ID_5197677.mp4")
//        val localFile = File.createTempFile("videos", "mp4")
//        ref.getFile(localFile).addOnSuccessListener {
//            onSuccess
//        }

        val videoUrl = intent.getStringExtra("VIDEO_URL")

        var mediaController = MediaController(this)

        videoView = findViewById(R.id.videoView)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
        val uri = Uri.parse(videoUrl)
        videoView.setVideoURI(uri)
//        videoView.requestFocus()
        videoView.start()
    }

}