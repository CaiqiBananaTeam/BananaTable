package com.flatig.banana.bananatable.ui.more

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flatig.banana.bananatable.R
import com.flatig.banana.bananatable.logic.model.MoreFragCardViewData

class MoreRecyclerAdapter(
    private val context: Context,
    private val moreFragCardViewList: List<MoreFragCardViewData>
) :
    RecyclerView.Adapter<MoreRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dataImage: ImageView = view.findViewById(R.id.moreRecycler_imageView)
        val dataText: TextView = view.findViewById(R.id.moreRecycler_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.more_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = moreFragCardViewList[position]
        holder.dataText.text = item.text
        Glide.with(context).load(item.resId).into(holder.dataImage)
    }

    override fun getItemCount(): Int {
        return moreFragCardViewList.size
    }

}