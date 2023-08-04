package com.jay.wackiestapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.jay.wackiestapp.activity.Activity1
import com.jay.wackiestapp.contentProvider.ContentProviderActivity
import com.jay.wackiestapp.services.ServiceActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)


        val btActivity=findViewById<Button>(R.id.btActivity)
        val btServices=findViewById<Button>(R.id.btServices)
        val btContentProvider=findViewById<Button>(R.id.btContentProvider)
        val btnBroadcastReceiver=findViewById<Button>(R.id.btBrodcastReceiver)

        btActivity.setOnClickListener{
            val intent= Intent(this@MainActivity,Activity1::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }

        btServices.setOnClickListener {
            val intent=Intent(this@MainActivity, ServiceActivity::class.java)
            startActivity(intent)
        }
        btContentProvider.setOnClickListener {
            val intent=Intent(this@MainActivity, ContentProviderActivity::class.java)
            startActivity(intent)
        }
        btnBroadcastReceiver.setOnClickListener {
            val intent=Intent(this@MainActivity, BroadcastReceiverActivity::class.java)
            startActivity(intent)
        }
    }//====================onCreate Ends=======================
}