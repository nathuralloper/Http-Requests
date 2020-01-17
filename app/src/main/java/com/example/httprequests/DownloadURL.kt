package com.example.httprequests

import android.os.AsyncTask
import android.os.StrictMode
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class DownloadURL(val completedListener: CompletedListener):AsyncTask<String, Void, String>() {
    override fun doInBackground(vararg params: String): String? {
        try {
            return downloadData(params[0])
        }catch(e:IOException){
            return null
        }
    }

    override fun onPostExecute(result: String) {
        try {
            completedListener?.downloadCompleted(result)
        }catch (e:IOException){

        }
    }

    @Throws(IOException::class)
    private fun downloadData(url:String):String{

       var inputStream: InputStream? = null

        try {
            val url = URL(url)
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.connect()

            inputStream = conn.inputStream
            return inputStream.bufferedReader().use {
                it.readText()
            }

        }finally {
            if (inputStream != null){
                inputStream.close()
            }
        }
    }
}