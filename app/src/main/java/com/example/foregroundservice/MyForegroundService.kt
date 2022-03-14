package com.example.foregroundservice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi

class MyForegroundService : Service() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(
            Runnable {

                run {
                    while (true) {
                        Log.d("ddddddddddd", "onStartCommand: service is running")
                        Thread.sleep(2000)
                    }
                }
            }
        ).start()

        val CHANNELID: String = "foreground service id"
        val channel = NotificationChannel(
            CHANNELID, CHANNELID, NotificationManager.IMPORTANCE_LOW
        )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val notification: Notification.Builder = Notification.Builder(this, CHANNELID)
            .setContentText("Service is running")
            .setContentTitle("Service Foreground")
            .setSmallIcon(R.drawable.ic_launcher_background)
        startForeground(10001,notification.build())
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}