package com.example.nails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Signup : AppCompatActivity() {

    var txtname2 = findViewById<EditText>(R.id.txtname2)
    var txtpass2 = findViewById<EditText>(R.id.txtpass2)
    var txtemail = findViewById<EditText>(R.id.txtemail)
    var txtphone = findViewById<EditText>(R.id.txtphone)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)






        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            addInfo()
            val intent = Intent(this@Signup, Signin::class.java)
            startActivity(intent)

        }

    }

    fun addInfo() {
        val name =txtname2.text.toString()
        val pass =txtpass2.text.toString()
        val phone=txtphone.text.toString()
        val email=txtemail.text.toString()

        if (name.isEmpty() || pass.isEmpty() || phone.isEmpty() || email.isEmpty()  ) {

            Toast.makeText(this , "Please fill all the required fields" , Toast.LENGTH_SHORT).show()

        }
        else{
            val std = BookingModel(username=name , password=pass , email=email , phone=phone)
            val status = SQLiteHelper.insertBookings(std)

            if (status > -1 ) {

                Toast.makeText(this , "Your account has been created." , Toast.LENGTH_SHORT).show()
                cleareditText()
            }
            else{

                Toast.makeText(this , "There was a problem ! Your account has not been created." , Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun cleareditText(){
        txtname2.setText("")
        txtpass2.setText("")
        txtemail.setText("")
        txtphone.setText("")
    }
}