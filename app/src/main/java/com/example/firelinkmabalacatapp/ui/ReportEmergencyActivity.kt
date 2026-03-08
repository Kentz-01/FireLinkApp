package com.example.firelinkmabalacatapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firelinkmabalacatapp.R
import org.osmdroid.views.MapView

class ReportEmergencyActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_report_emergency)

        val map = findViewById<MapView>(R.id.map)
        map.setMultiTouchControls(true)
        map.controller.setZoom(18.0)

        val spinner = findViewById<Spinner>(R.id.spinnerEmergency)

        val emergencyTypes = arrayOf(
            "Select Emergency Type",
            "Fire",
            "Flood",
            "Accident",
            "Earthquake",
            "Other"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            emergencyTypes
        )

        spinner.adapter = adapter

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {

            val referenceNumber = "REF-" + System.currentTimeMillis()

            Toast.makeText(
                this,
                "Report Sent Successfully!\nReference: $referenceNumber",
                Toast.LENGTH_LONG
            ).show()
        }

    }
}