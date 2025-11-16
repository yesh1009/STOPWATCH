package com.yash.stopwatch



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnLaps = findViewById<Button>(R.id.btnLaps)
        val btnExit = findViewById<Button>(R.id.btnExit)

        btnStart.setOnClickListener {
            startActivity(Intent(this, StopwatchActivity::class.java))
        }

        btnLaps.setOnClickListener {
            startActivity(Intent(this, LapsActivity::class.java))
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}
