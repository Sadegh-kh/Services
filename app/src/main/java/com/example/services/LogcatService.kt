package com.example.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class LogcatService : Service() {

    override fun onCreate() {
        super.onCreate()
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        startForeground(1110,getNotification())

        Thread.sleep(8000)
        stopSelf()

        return START_STICKY
    }

    private fun doMyJob() {
        for (i in 0..100000){
            Log.v("testService","$i ")
        }
    }


    override fun onDestroy() {
        stopForeground(true )
        super.onDestroy()
    }




    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun getNotification():Notification{

        val notificationManage=getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel=NotificationChannel("first Chanel","ChanelMusic",NotificationManager.IMPORTANCE_HIGH)
            notificationManage.createNotificationChannel(notificationChannel)
        }
        val notification=NotificationCompat.Builder(this,"first Chanel")
            .setSmallIcon(android.R.drawable.stat_notify_chat)
            .setContentTitle("service running...")
            .setContentText("Hacking :D ")
            .build()

        return notification

    }
}