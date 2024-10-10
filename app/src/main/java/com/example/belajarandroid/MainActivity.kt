package com.example.belajarandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.belajarandroid.activity.LatihanActivity
import com.example.belajarandroid.async_background_thread.LatihanAsynchronousBackgroundThread
import com.example.belajarandroid.fragment.LatihanFragment
import com.example.belajarandroid.intent.LatihanIntent
import com.example.belajarandroid.live_data.LatihanLiveData
import com.example.belajarandroid.local_data_persistent.LatihanLocalDataPersistent
import com.example.belajarandroid.navigation.LatihanNavigation
import com.example.belajarandroid.networking_loopj_parsing_json.LatihanNetworkingLoopJParsingJSON
import com.example.belajarandroid.networking_retrofit_api.ui.LatihanNetworkingRetrofit
import com.example.belajarandroid.recycle_view.LatihanRecycleView
import com.example.belajarandroid.view_model.LatihanViewModel
import com.example.belajarandroid.views_and_view_group.LatihanViewsAndViewGroup

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
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
        val btnMoveLatihanNavigation: Button = findViewById(R.id.btn_move_latihan_navigation)
        val btnMoveLatihanAsyncBackgroundThread: Button =
            findViewById(R.id.btn_move_latihan_async_background_thread)
        val btnMoveLatihanNetworking: Button = findViewById(R.id.btn_move_latihan_networking)
        val btnMoveLatihanNetworkingRetrofit: Button =
            findViewById(R.id.btn_move_latihan_networking_retrofit)
        val btnMoveLatihanViewModel: Button = findViewById(R.id.btn_move_latihan_view_model)
        val btnMoveLatihanLiveData: Button = findViewById(R.id.btn_move_latihan_live_data)
        val btnMoveLatihanLocalDataPersistent: Button =
            findViewById(R.id.btn_move_latihan_local_data_persistent)

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

        btnMoveLatihanNavigation.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanNavigation::class.java))
        }

        btnMoveLatihanAsyncBackgroundThread.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    LatihanAsynchronousBackgroundThread::class.java
                )
            )
        }

        btnMoveLatihanNetworking.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanNetworkingLoopJParsingJSON::class.java))
        }

        btnMoveLatihanNetworkingRetrofit.setOnClickListener {
            startActivity(Intent(this@MainActivity, LatihanNetworkingRetrofit::class.java))
        }

        btnMoveLatihanViewModel.setOnClickListener {
            startActivity((Intent(this@MainActivity, LatihanViewModel::class.java)))
        }

        btnMoveLatihanLiveData.setOnClickListener {
            startActivity((Intent(this@MainActivity, LatihanLiveData::class.java)))
        }

        btnMoveLatihanLocalDataPersistent.setOnClickListener {
            startActivity((Intent(this@MainActivity, LatihanLocalDataPersistent::class.java)))
        }
    }
}
