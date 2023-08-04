package com.jay.wackiestapp

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import java.util.Timer
import java.util.TimerTask

class BroadcastReceiverActivity : AppCompatActivity() {
    private val textView:TextView by lazy{findViewById(R.id.textView)}
    private val editText: EditText by lazy{findViewById(R.id.editTextText)}

    private var timer:Timer?=null
    private val handler=Handler(Looper.getMainLooper())

    //    broadcast receiver
    private val broadcastReceiver=object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val receivedText=intent?.getStringExtra("text")
            receivedText?.let {
                textView.text=it
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_brodcast_receiver)

        val sendButton=findViewById<Button>(R.id.btSend)
        val startSendButton=findViewById<Button>(R.id.btStart)
        val stopSendButton=findViewById<Button>(R.id.btStop)

        startSendButton.setOnClickListener {
            val text=editText.text.toString()
            sendBroadcast(text)
        }

        sendButton.setOnClickListener {
            startBroadcastSending()
        }

        stopSendButton.setOnClickListener {
            stopBroadcasting()
        }
    }//====================onCreate Ends=======================

    private fun sendBroadcast(text: String) {
        val intent=Intent("my_broadcast_action")
        intent.putExtra("text",text)
        sendBroadcast(intent)

    }

    private fun startBroadcastSending() {
        timer=Timer()
        timer?.schedule(object :TimerTask(){
            override fun run() {
                handler.post{
                    val text=editText.text.toString()
                    textView.text=text
                }
                val text=editText.text.toString()
                sendBroadcast(text)
            }
        },0,100)
    }

    private fun stopBroadcasting() {
        timer?.cancel()
        timer=null

    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onResume() {
        super.onResume()
        registerReceiver(broadcastReceiver, IntentFilter("my_broadcast_action"))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastReceiver)
    }
}
