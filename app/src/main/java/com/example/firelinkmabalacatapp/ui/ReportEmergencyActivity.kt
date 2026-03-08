package com.example.firelinkmabalacatapp.ui

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.firelinkmabalacatapp.R
import org.osmdroid.views.MapView
import android.Manifest

class ReportEmergencyActivity : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")


    //Location

    private val locationPermissionRequestCode = 100

    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                locationPermissionRequestCode
            )
        } else {
            enableAutoLocate()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == locationPermissionRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableAutoLocate()
            } else {
                Toast.makeText(this, "Location permission required for map", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun enableAutoLocate() {
        findViewById<Button>(R.id.btnAutoLocate).setOnClickListener {
            // Implement actual location fetching
            Toast.makeText(this, "Getting location...", Toast.LENGTH_SHORT).show()
        }
    }
    
    //-------------------------------------------


   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_report_emergency)

       checkLocationPermission()   // ← just added, might delete later

        val map = findViewById<MapView>(R.id.mapView)
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