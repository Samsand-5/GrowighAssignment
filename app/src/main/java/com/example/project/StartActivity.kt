package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {

    lateinit var btnFeed:Button
    lateinit var btnUpload:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btnFeed = findViewById(R.id.btn_feeds)
        btnUpload = findViewById(R.id.btn_upload)

        btnFeed.setOnClickListener {
            val intent = Intent(this,FeedsActivity::class.java)
            startActivity(intent)
        }
        btnUpload.setOnClickListener {
            val intent = Intent(this,UploadActivity::class.java)
            startActivity(intent)
        }
    }
}