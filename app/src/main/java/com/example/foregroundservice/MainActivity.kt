package com.example.foregroundservice

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!foregroundServiceRunning()) {
            startForegroundService(Intent(this, MyForegroundService::class.java))
        }

    }

    fun foregroundServiceRunning(): Boolean {
        val activityManager: ActivityManager =
            getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service: ActivityManager.RunningServiceInfo in activityManager.getRunningServices((Int.MAX_VALUE))) {
            if (MyForegroundService::class.java.name.equals(service.service.className)) {
                return true
            }
        }
        return false
    }
}