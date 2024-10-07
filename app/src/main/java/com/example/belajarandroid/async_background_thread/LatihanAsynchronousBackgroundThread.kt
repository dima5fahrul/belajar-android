package com.example.belajarandroid.async_background_thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.belajarandroid.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class LatihanAsynchronousBackgroundThread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_asynchronous_background_thread)

        val btnStart = findViewById<Button>(R.id.btn_start)
        val tvStatus = findViewById<TextView>(R.id.tv_status)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        btnStart.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                for (i in 0..10) {
                    delay(500)
                    val percentage = i * 10
                    launch(Dispatchers.Main) {
                        if (percentage == 100) {
                            tvStatus.setText(R.string.task_completed)
                        } else {
                            tvStatus.text =
                                String.format(getString(R.string.compressing), percentage)
                        }
                    }
                }
            }

//            try {
//                for (i in 0..10) {
//                    Thread.sleep(500)
//                    val percentage = i * 10
//                    handler.post {
//                        if (percentage == 100) {
//                            tvStatus.setText(R.string.task_completed)
//                        } else {
//                            tvStatus.text =
//                                String.format(getString(R.string.compressing), percentage)
//                        }
//                    }
//                }
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
        }
    }
}