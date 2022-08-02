package com.example.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class LogcatService : Service() {

    override fun onCreate() {
        super.onCreate()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        doMyJob()
        return START_STICKY
    }

    private fun doMyJob() {
        for (i in 0..100000){
            Log.v("testService","$i ")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
    }




    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}