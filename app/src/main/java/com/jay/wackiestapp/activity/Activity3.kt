package com.jay.wackiestapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.jay.wackiestapp.R

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_3)
        val btNext3=findViewById<Button>(R.id.btNext3)
        val btBack3=findViewById<Button>(R.id.btBack3)

        //this start new activity 4

        btNext3.setOnClickListener{
            val intent= Intent(this@Activity3,Activity4::class.java)
            startActivity(intent)
        }

        // by back button it finishing this activity

        btBack3.setOnClickListener{
           finish()

        }
    }//====================onCreate Ends=======================


    }
