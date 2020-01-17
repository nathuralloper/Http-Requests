package com.example.httprequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnValidate = findViewById<Button>(R.id.btnValidate)
        btnValidate.setOnClickListener{
            if (Network.ThereIsNetwork(this)){
                Toast.makeText(this, "You have internet", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Make sure there is an internet connection!", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
