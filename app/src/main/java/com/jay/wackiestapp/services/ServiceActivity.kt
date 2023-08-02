package com.jay.wackiestapp.services

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.jay.wackiestapp.R

class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ),0
        )

        val start:Button=findViewById(R.id.btStart)
        val stop:Button=findViewById(R.id.btStop)

        start.setOnClickListener {
            Intent(applicationContext,LocationService::class.java).apply {
                action=LocationService.ACTION_START
                startService(this)
            }
        }
        stop.setOnClickListener {
            Intent(applicationContext,LocationService::class.java).apply {
                action=LocationService.ACTION_STOP
                startService(this)
            }
        }

    }
}
