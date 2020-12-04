package com.app.gradhack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.ArrayList


class HomeActivity : AppCompatActivity() {
    //vars
    private var mImageUrls = ArrayList<String>()
    private var mVideoUrls = ArrayList<String>()
    private lateinit var videosButton : ImageButton
    override fun onCreate(
        savedInstanceState: Bundle
        ?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
        val videosRef: DatabaseReference = rootRef.child("videos")

        videosRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                mImageUrls.clear()
                mVideoUrls.clear()
                for (videoSnapshot in dataSnapshot.children){
                    val videoUrls: VideoUrls? = videoSnapshot.getValue(VideoUrls::class.java)
                    if (videoUrls != null){
                        mImageUrls.add(videoUrls.thumbnailUrl)
                        mVideoUrls.add(videoUrls.videoUrl)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        initRecyclerView()
        videosButton = findViewById(R.id.videosButton)
        videosButton.setOnClickListener{
            openVideosActivity(mImageUrls, mVideoUrls)
        }
    }

    fun openVideosActivity(iUrls: ArrayList<String>, vUrls: ArrayList<String>){
        val intent = Intent(this, VideosActivity::class.java)
        intent.putExtra("IMAGE_URLS",iUrls)
        intent.putExtra("VIDEO_URLS", vUrls)
        startActivity(intent)
    }


    private fun initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview")
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerViewAdapter(this, mImageUrls, mVideoUrls)
        recyclerView.adapter = adapter
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    class VideoUrls{
        lateinit var thumbnailUrl: String
        lateinit var videoUrl: String
    }
}