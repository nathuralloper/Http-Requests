package com.example.httprequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity(), CompletedListener {
    override fun downloadCompleted(result: String) {
        Log.d("download", result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnValidate = findViewById<Button>(R.id.btnValidate)
        val btnHttpRequest = findViewById<Button>(R.id.btnHttpRequest)

        btnValidate.setOnClickListener{
            if (Network.ThereIsNetwork(this)){
                Toast.makeText(this, "You have internet", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Make sure there is an internet connection!", Toast.LENGTH_SHORT).show()
            }
        }

        btnHttpRequest.setOnClickListener{
            if (Network.ThereIsNetwork(this)){
              DownloadURL(this).execute("http://google.com")
            }else{
                Toast.makeText(this, "Make sure there is an internet connection!", Toast.LENGTH_SHORT).show()
            }
        }
    }




}
