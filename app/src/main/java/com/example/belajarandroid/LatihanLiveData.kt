package com.example.belajarandroid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.belajarandroid.databinding.ActivityLatihanLiveDataBinding

class LatihanLiveData : AppCompatActivity() {
    private lateinit var liveDataTimerViewModel: MainViewModelLiveData
    private lateinit var activityLatihanLiveDataBinding: ActivityLatihanLiveDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_live_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        activityLatihanLiveDataBinding = ActivityLatihanLiveDataBinding.inflate(layoutInflater)
        setContentView(activityLatihanLiveDataBinding.root)

        liveDataTimerViewModel = ViewModelProvider(this)[MainViewModelLiveData::class.java]
        subscribe()
    }

    private fun subscribe() {
        val elapsedTimeObserver = Observer<Long?> { along ->
            val newText = this@LatihanLiveData.resources.getString(R.string.seconds, along)
            activityLatihanLiveDataBinding.timerTextview.text = newText
        }

        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver)
    }
}