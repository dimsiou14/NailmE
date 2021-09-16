package com.example.nails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val imgbtna = findViewById<ImageButton>(R.id.imgbtna)
        imgbtna.setOnClickListener {
            val intent = Intent(this@Menu , Appointments::class.java)
            startActivity(intent)
        }

        val imgbtng = findViewById<ImageButton>(R.id.imgbtng)
        imgbtng.setOnClickListener {
            val intent = Intent(this@Menu , Gallery::class.java)
            startActivity(intent)
        }
    }
}