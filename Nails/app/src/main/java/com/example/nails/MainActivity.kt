package com.example.nails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btnsignin)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity, Signin::class.java)
                        startActivity (intent)

        }

        val button2 = findViewById<Button>(R.id.btnsignup)
        button2.setOnClickListener {
            val intent = Intent(this@MainActivity, Signup::class.java)
                        startActivity (intent)

        }




    }
}