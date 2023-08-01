package com.jay.wackiestapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jay.wackiestapp.MainActivity
import com.jay.wackiestapp.R

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val btNext1=findViewById<Button>(R.id.btNext1)
        val btBack1=findViewById<Button>(R.id.btBack1)


        //Next navigate to Second Activity
        //this start new activity 2
        btNext1.setOnClickListener{
            val intent= Intent(this@Activity1,Activity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        //Back navigate to MainActivity
        
        btBack1.setOnClickListener{
            finish()
        }
    }
}