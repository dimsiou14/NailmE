package com.example.nails


import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager


class ViewPagerAdapter (private var title: List<String> , private var details: List<String>, private var images: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>(){
    inner class Pager2ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.tvtitle)
        val itemDetails: TextView = itemView.findViewById(R.id.tvdetail)
        val itemImages: TextView = itemView.findViewById(R.id.tvimage)


        init {

            itemImages.setOnClickListener { v: View ->
                val position: Int = adapterPosition

            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page,parent,false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetails.text = details[position]
        holder.itemImages.setImagesRecource(images[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }


}
