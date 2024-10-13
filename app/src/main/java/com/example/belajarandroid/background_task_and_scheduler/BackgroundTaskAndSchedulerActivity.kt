package com.example.belajarandroid.background_task_and_scheduler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.belajarandroid.R
import com.example.belajarandroid.background_task_and_scheduler.broadcast_receiver.BroadcastReceiverActivity
import com.example.belajarandroid.background_task_and_scheduler.notification.NotificationBuilderDanNotificationManagerActivity
import com.example.belajarandroid.background_task_and_scheduler.one_time_alarmmanager.OneTimeAlarmManagerActivity

class BackgroundTaskAndSchedulerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_background_task_and_scheduler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMoveBroadcastReceiverActivity: Button =
            findViewById(R.id.btn_move_broadcast_receiver)
        btnMoveBroadcastReceiverActivity.setOnClickListener {
            startActivity(
                Intent(
                    this@BackgroundTaskAndSchedulerActivity,
                    BroadcastReceiverActivity::class.java
                )
            )
        }

        val btnMoveNotificationActivity: Button = findViewById(R.id.btn_move_notification)
        btnMoveNotificationActivity.setOnClickListener {
            startActivity(
                Intent(
                    this@BackgroundTaskAndSchedulerActivity,
                    NotificationBuilderDanNotificationManagerActivity::class.java
                )
            )
        }

        val btnMoveOneTimeAlarmActivity: Button = findViewById(R.id.btn_move_alarm_manager)
        btnMoveOneTimeAlarmActivity.setOnClickListener {
            startActivity(
                Intent(
                    this@BackgroundTaskAndSchedulerActivity,
                    OneTimeAlarmManagerActivity::class.java
                )
            )
        }
    }
}