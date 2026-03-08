package com.example.firelinkmabalacatapp.ui

import EmergencyReport
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firelinkmabalacatapp.R
import com.example.firelinkmabalacatapp.model.EmergencyReport

class ConfirmLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_location)

        // Get data from previous activity
        val emergencyReport = intent.getParcelableExtra<EmergencyReport>("emergency_report")

        // Display confirmation
        findViewById<TextView>(R.id.tvConfirmation).text =
            "Confirm Report: ${emergencyReport?.emergencyType}"

        findViewById<Button>(R.id.btnConfirm).setOnClickListener {
            // Send to server/database
            Toast.makeText(this, "Report Confirmed!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}