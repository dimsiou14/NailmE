package com.example.nails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


class Appointments : AppCompatActivity() {

   private lateinit var sqLiteHelper: SQLiteHelper
   private lateinit var  recyclerView:RecyclerView
   private  var adapter:BookingAdapter? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        var txtperson = findViewById<EditText>(R.id.txtperson)
        var txtdate = findViewById<EditText>(R.id.txtdate)
        var txttime = findViewById<EditText>(R.id.txttime)
        var btnbook = findViewById<Button>(R.id.btnbook)
        var btndelete = findViewById<Button>(R.id.btndelete)
        var btnview = findViewById<Button>(R.id.btnview)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)





        recyclerView.layoutManager(this)
        adapter=BookingAdapter()
        recyclerView.adapter=adapter

            btnview.setOnClickListener(viewBook())



    }

    fun viewBook() {
        val name =txtperson.text.toString()
        val date =txtdate.text.toString()
        val time=txttime.text.toString()




        val std = BookingModel(username=name , date=date , time=time)
        val status = SQLiteHelper.viewBookings(std)




    }









}