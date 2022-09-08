package com.flatig.banana.bananatable.ui.me

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flatig.banana.bananatable.R
import com.flatig.banana.bananatable.logic.model.MeFragRecyclerViewData


class MeRecyclerAdapter(
    private val context: Context,
    private val meFragRecyclerViewList: List<MeFragRecyclerViewData>
) :
    RecyclerView.Adapter<MeRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dataImage: ImageView = view.findViewById(R.id.meRecycler_imageView)
        val dataText: TextView = view.findViewById(R.id.meRecycler_textView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MeRecyclerAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.me_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = meFragRecyclerViewList[position]
        holder.dataText.text = item.text
        holder.dataImage.setImageDrawable(ContextCompat.getDrawable(context, item.resId))
    }

    override fun getItemCount(): Int {
        return meFragRecyclerViewList.size
    }


}