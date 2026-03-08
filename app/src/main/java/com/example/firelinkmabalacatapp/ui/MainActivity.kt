package com.example.firelinkmabalacatapp.ui

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.firelinkmabalacatapp.R
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnReport = findViewById<Button>(R.id.btnReport)
        val btnSafety = findViewById<Button>(R.id.btnSafety)
        val btnHotline = findViewById<Button>(R.id.btnHotline)
        val btnAnnouncements = findViewById<Button>(R.id.btnAnnouncements)

        // Animate buttons on start
        animateButton(btnReport, 0)
        animateButton(btnSafety, 100)
        animateButton(btnHotline, 200)
        animateButton(btnAnnouncements, 300)

        // 🚨 Report Emergency
        btnReport.setOnClickListener {
            startActivity(Intent(this, ReportEmergencyActivity::class.java))
        }

        // 🟡 Safety Tips
        btnSafety.setOnClickListener {
            startActivity(Intent(this, SafetyTipsActivity::class.java))
        }

        // 🔵 Hotlines
        btnHotline.setOnClickListener {
            startActivity(Intent(this, HotlineActivity::class.java))
        }

        // 🟢 Announcements
        btnAnnouncements.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }
    }
    private fun animateButton(button: Button, delay: Long) {

        button.alpha = 0f
        button.scaleX = 0.8f
        button.scaleY = 0.8f

        val fadeIn = ObjectAnimator.ofFloat(button, "alpha", 0f, 1f)
        val scaleX = ObjectAnimator.ofFloat(button, "scaleX", 0.8f, 1f)
        val scaleY = ObjectAnimator.ofFloat(button, "scaleY", 0.8f, 1f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(fadeIn, scaleX, scaleY)
        animatorSet.startDelay = delay
        animatorSet.duration = 400
        animatorSet.start()
    }
}
