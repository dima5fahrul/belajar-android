package com.example.belajarandroid.local_data_persistent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.belajarandroid.R
import com.example.belajarandroid.local_data_persistent.setting_shared_preferences.SharedPreferenceSettings
import com.example.belajarandroid.local_data_persistent.shared_preferences.SharedPreferencesStorage

class LatihanLocalDataPersistent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_local_data_persistent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMoveSharedPreferencesStorage: Button = findViewById(R.id.btn_shared_preferences)
        val btnMoveSharedPreferencesSettings: Button =
            findViewById(R.id.btn_shared_preferences_setting)

        btnMoveSharedPreferencesStorage.setOnClickListener {
            startActivity(
                Intent(
                    this@LatihanLocalDataPersistent,
                    SharedPreferencesStorage::class.java
                )
            )
        }

        btnMoveSharedPreferencesSettings.setOnClickListener {
            startActivity(
                Intent(
                    this@LatihanLocalDataPersistent,
                    SharedPreferenceSettings::class.java
                )
            )
        }
    }
}