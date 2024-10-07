package com.example.belajarandroid.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.belajarandroid.R
import com.example.belajarandroid.navigation.navigation_graph.NavigationGraph
import com.example.belajarandroid.navigation.option_menu_bar.OptionMenuAppBar

class LatihanNavigation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMoveNavigationGraph: Button = findViewById(R.id.btn_move_navigation_graph)
        val btnMoveOptionMenuAppbar: Button = findViewById(R.id.btn_move_option_menu_appbar)

        btnMoveNavigationGraph.setOnClickListener {
            startActivity(Intent(this@LatihanNavigation, NavigationGraph::class.java))
        }

        btnMoveOptionMenuAppbar.setOnClickListener {
            startActivity(Intent(this@LatihanNavigation, OptionMenuAppBar::class.java))
        }
    }
}