package com.jay.wackiestapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.jay.wackiestapp.R

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_2)

        val btNext2=findViewById<Button>(R.id.btNext2)
        val btBack2=findViewById<Button>(R.id.btBack2)


//      this start new activity 3
        btNext2.setOnClickListener {
            val intent = Intent(this@Activity2, Activity3::class.java)
            startActivity(intent)
        }

        //       by back button it finishing this activity

        btBack2.setOnClickListener{
            finish()
        }
    }//====================onCreate Ends=======================
}