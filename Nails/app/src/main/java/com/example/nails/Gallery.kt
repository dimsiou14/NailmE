package com.example.nails

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class Gallery : AppCompatActivity() {


    private var titlesList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)



        postToList()
        view_pager2.adapter = ViewPagerAdapter(titlesList, detailsList, imagesList)
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator: CircleIndicator3 = findViewById<CircleIndicator>(R.id.indicator)
        indicator.setViewPager(view_pager2)

    }
    private fun addToList(title:String , details:String , images:Int){
        titlesList.add(title)
        detailsList.add(details)
        imagesList.add(images)
    }

    private fun postToList(){
        for (i:Int in 1..5){
            addToList(title:"title is $i" , details:"detail is $i" , R.mipmap.ic_launcher_round)
        }
    }



}