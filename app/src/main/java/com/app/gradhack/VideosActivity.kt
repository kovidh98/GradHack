package com.app.gradhack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VideosActivity : AppCompatActivity() {
    private lateinit var backButton : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)
        var mImageUrls = intent.getStringArrayListExtra("IMAGE_URLS")
        var mVideoUrls = intent.getStringArrayListExtra("VIDEO_URLS")
        if (mImageUrls != null && mVideoUrls != null) {
            initRecyclerView(mImageUrls, mVideoUrls)
        }
        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
    private fun initRecyclerView(mImageUrls: ArrayList<String>, mVideoUrls: ArrayList<String>) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerViewAdapter(this, mImageUrls, mVideoUrls)
        recyclerView.adapter = adapter

        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView2.layoutManager = layoutManager2
        val adapter2 = RecyclerViewAdapter(this, mImageUrls, mVideoUrls)
        recyclerView2.adapter = adapter2
    }
}