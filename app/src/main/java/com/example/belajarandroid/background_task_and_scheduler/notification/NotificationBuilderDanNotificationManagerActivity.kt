package com.example.belajarandroid.background_task_and_scheduler.notification

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.belajarandroid.R
import com.example.belajarandroid.databinding.ActivityNotificationBuilderDanNotificationManagerBinding

class NotificationBuilderDanNotificationManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBuilderDanNotificationManagerBinding

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notification_builder_dan_notification_manager)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityNotificationBuilderDanNotificationManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= 33) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        val title = getString(R.string.notification_title)
        val message = getString(R.string.notification_message)

        binding.btnSendNotification.setOnClickListener {
            sendNotification(title, message)
        }
        binding.btnOpenDetail.setOnClickListener {
            val detailIntent = Intent(this, DetailNotificationActivity::class.java)
            detailIntent.putExtra(DetailNotificationActivity.EXTRA_TITLE, title)
            detailIntent.putExtra(DetailNotificationActivity.EXTRA_MESSAGE, message)
            startActivity(detailIntent)
        }
    }

    private fun sendNotification(title: String, message: String) {
        val notifDetailIntent = Intent(this, DetailNotificationActivity::class.java)
        notifDetailIntent.putExtra(DetailNotificationActivity.EXTRA_TITLE, title)
        notifDetailIntent.putExtra(DetailNotificationActivity.EXTRA_MESSAGE, message)

        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(notifDetailIntent)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getPendingIntent(
                    NOTIFICATION_ID,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
            } else {
                getPendingIntent(NOTIFICATION_ID, PendingIntent.FLAG_UPDATE_CURRENT)
            }
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(title)
            .setSmallIcon(R.drawable.baseline_notifications_24).setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setSubText(getString(R.string.notification_subtext))
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            builder.setChannelId(CHANNEL_ID)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = builder.build()
        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "channel_01"
        private const val CHANNEL_NAME = "dicoding channel"
    }
}