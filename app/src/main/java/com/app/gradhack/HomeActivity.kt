package com.app.gradhack

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class HomeActivity : AppCompatActivity() {
    //vars
    private var mNames = ArrayList<String>()
    private var mImageUrls = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        images
    }

    private val images: Unit
        get() {
            Log.d(TAG, "initImageBitmaps: preparing bitmaps.")
            mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOYv5q5Y0rDQhq32_iFHB41mIB0iMKbEAmzg&usqp=CAU")
            mNames.add("Havasu Falls")
            mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKPnWx61w9Qb0095fwycNxrA30xcYOCMiQ1w&usqp=CAU")
            mNames.add("Trondheim")
            mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTX9pe9xa3QIl-WGJNXGQydF30s-RB81Q4cuw&usqp=CAU")
            mNames.add("Portugal")
            mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSscOZbd-NokA_wipzLFsWXYwX2Ip9ZLslbGA&usqp=CAU")
            mNames.add("Rocky Mountain National Park")
            mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3jIQ84vBzPIwkypyeAWhsQhp_5WNzvnoqFg&usqp=CAU")
            mNames.add("Mahahual")
            initRecyclerView()
        }

    private fun initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview")
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerViewAdapter(this, mImageUrls)
        recyclerView.adapter = adapter
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}