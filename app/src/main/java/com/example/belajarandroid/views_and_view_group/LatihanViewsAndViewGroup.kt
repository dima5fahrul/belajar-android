package com.example.belajarandroid.views_and_view_group

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarandroid.R

class LatihanViewsAndViewGroup : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_views_and_view_group)

        val btnMoveToLinearRealtiveFrameAndTableLayout: Button =
            findViewById(R.id.btn_move_to_linear_relative_frame_table_layout)
        btnMoveToLinearRealtiveFrameAndTableLayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_move_to_linear_relative_frame_table_layout -> {
                startActivity(Intent(this, LinearRealtiveFrameAndTableLayout::class.java))
            }
        }
    }
}