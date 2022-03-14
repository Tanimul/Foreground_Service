package com.example.foregroundservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class MYBoardCastReceiver: BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(p0: Context?, p1: Intent?) {
        if (p1 != null) {
            if(p1.action.equals(Intent.ACTION_BOOT_COMPLETED)){

                p0!!.startForegroundService(Intent(p0,MyForegroundService::class.java))
            }
        }
    }
}