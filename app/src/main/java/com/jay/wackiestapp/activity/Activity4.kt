package com.jay.wackiestapp.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.jay.wackiestapp.R

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)


        val btBack4=findViewById<Button>(R.id.btBack4)
        val btFinish=findViewById<Button>(R.id.btFinish)

//       by back button it finishing this activity
        btBack4.setOnClickListener{
            finish()
        }
//     by finish button it close all backStack activity and start from first activity
        btFinish.setOnClickListener{

        finishAffinity()
        }
    }






}

