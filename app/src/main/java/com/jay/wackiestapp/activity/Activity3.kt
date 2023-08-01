package com.jay.wackiestapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jay.wackiestapp.R

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    }


    }
