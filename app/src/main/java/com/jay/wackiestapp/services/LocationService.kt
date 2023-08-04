package com.jay.wackiestapp.services

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.google.android.gms.location.LocationServices
import com.jay.wackiestapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LocationService : Service() {


    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var locationClient: LocationClient
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        locationClient = DefaultLocationClient(
            applicationContext,
            LocationServices.getFusedLocationProviderClient(applicationContext)
        )
    }//====================onCreate Ends=======================

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> start()
            ACTION_STOP -> stop()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {

        //creating notification
        val notification = NotificationCompat.Builder(this, "location")
            .setContentTitle("Bro I Am Tracking Your Location Hehe ;)")
            .setContentText("Location:null")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setOngoing(true)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //updating notification
        locationClient.getLocationUpdates(10000L)
            .catch { e ->
                e.printStackTrace() }
            .onEach { location ->
                val lat = location.toString()
                val long = location.toString()
                val updateNotification = notification.setContentText(
                    "Location: ($lat,$long)"
                )

                notificationManager.notify(1, updateNotification.build())
            }
            .launchIn(serviceScope)

        startForeground(1, notification.build())
    }

    //for  onClick Stop button
    private fun stop() {
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()

    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }

    companion object {
        const val ACTION_START = "ACTION_START"
        const val ACTION_STOP = "ACTION_STOP"

    }

}