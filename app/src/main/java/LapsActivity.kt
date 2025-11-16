package com.yash.stopwatch



import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class LapsActivity : AppCompatActivity() {

    private lateinit var lapListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laps)

        lapListView = findViewById(R.id.listLaps)

        // Load laps from global history
        val laps = LapHistory.laps
        val adapter = LapAdapter(this, laps)
        lapListView.adapter = adapter
    }
}
