package com.yash.stopwatch




import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class StopwatchActivity : AppCompatActivity() {

    private lateinit var txtTimer: TextView
    private lateinit var btnStart: Button
    private lateinit var btnPause: Button
    private lateinit var btnReset: Button

    private var seconds = 0
    private var running = false
    private val handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)

        // Initialize views
        txtTimer = findViewById(R.id.txtTimer)
        btnStart = findViewById(R.id.btnStart)
        btnPause = findViewById(R.id.btnPause)
        btnReset = findViewById(R.id.btnReset)

        // Start button
        btnStart.setOnClickListener { running = true }

        // Pause button
        btnPause.setOnClickListener { running = false }

        // Reset button
        btnReset.setOnClickListener {
            if (seconds != 0) {
                // Save current time to global laps history
                val hrs = seconds / 3600
                val mins = (seconds % 3600) / 60
                val secs = seconds % 60
                LapHistory.laps.add(String.format("%02d:%02d:%02d", hrs, mins, secs))
            }
            running = false
            seconds = 0
            txtTimer.text = "00:00:00"
        }

        runTimer()
    }

    // Timer updates every second
    private fun runTimer() {
        handler.post(object : Runnable {
            override fun run() {
                val hrs = seconds / 3600
                val mins = (seconds % 3600) / 60
                val secs = seconds % 60

                txtTimer.text = String.format("%02d:%02d:%02d", hrs, mins, secs)

                if (running) {
                    seconds++
                }

                handler.postDelayed(this, 1000)
            }
        })
    }
}
