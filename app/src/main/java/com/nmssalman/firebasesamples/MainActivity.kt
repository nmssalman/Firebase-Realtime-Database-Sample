package com.nmssalman.firebasesamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.nmssalman.firebasesamples.realtime.RealtimeActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnRealtime: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRealtime = findViewById(R.id.btnRealtime)
        btnRealtime.setOnClickListener {
            val i = Intent(this, RealtimeActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}