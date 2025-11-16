package com.yash.stopwatch



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class LapAdapter(context: Context, private val laps: ArrayList<String>) :
    ArrayAdapter<String>(context, 0, laps) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.lap_item, parent, false)

        val txtLap = view.findViewById<TextView>(R.id.txtLap)
        txtLap.text = "Lap ${position + 1}: ${laps[position]}"

        return view
    }
}
