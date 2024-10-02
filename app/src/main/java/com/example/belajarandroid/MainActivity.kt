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
        val btnMoveLatihanViewAndViewGroup: Button =
            findViewById(R.id.btn_move_latihan_views_and_view_group)
        val btnMoveLatihanRecycleView: Button =
            findViewById(R.id.btn_move_latihan_recycle_view)
        val btnMoveLatihanFragment: Button = findViewById(R.id.btn_move_latihan_fragment)

        btnMoveLatihanActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanActivity::class.java))
        }

        btnMoveLatihanIntent.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanIntent::class.java))
        }

        btnMoveLatihanViewAndViewGroup.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanViewsAndViewGroup::class.java))
        }

        btnMoveLatihanRecycleView.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanRecycleView::class.java))
        }

        btnMoveLatihanFragment.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanFragment::class.java))
        }
    }
}
