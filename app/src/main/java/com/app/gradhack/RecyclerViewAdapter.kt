package com.app.gradhack

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

class RecyclerViewAdapter(mContext: Context, mImageUrls: ArrayList<String>, mVideoUrls: ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var mImageUrls = ArrayList<String>()
    private var mVideoUrls = ArrayList<String>()
    private val mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")
        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls[position])
                .into(holder.image)
        holder.image.setOnClickListener {
            Log.d(TAG, "onClick: Clicked on an image")
            val intent = Intent(mContext, VideoViewActivity::class.java)
            intent.putExtra("VIDEO_URL", mVideoUrls[position])
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mImageUrls.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView

        init {
            image = itemView.findViewById(R.id.imageView)
        }
    }

    companion object {
        private const val TAG = "RecyclerViewAdapter"
    }

    init {
        this.mImageUrls = mImageUrls
        this.mVideoUrls = mVideoUrls
        this.mContext = mContext
    }
}