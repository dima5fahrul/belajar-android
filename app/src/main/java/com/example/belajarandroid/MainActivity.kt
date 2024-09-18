package com.example.belajarandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnMoveLatihanActivity: Button = findViewById(R.id.btn_move_latihan_activity)
        val btnMoveLatihanIntent: Button = findViewById(R.id.btn_move_latihan_intent)

        btnMoveLatihanActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanActivity::class.java))
        }

        btnMoveLatihanIntent.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanIntent::class.java))
        }
    }
}
