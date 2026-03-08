package com.example.firelinkmabalacatapp.ui

import NotificationItem
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.firelinkmabalacatapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firelinkmabalacatapp.adapter.NotificationAdapter

class NotificationsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var notificationAdapter: NotificationAdapter
    private val notificationList = mutableListOf<NotificationItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notifications)

        recyclerView = findViewById(R.id.recyclerViewNotifications)
        recyclerView.layoutManager = LinearLayoutManager(this)

        notificationAdapter = NotificationAdapter(notificationList)
        recyclerView.adapter = notificationAdapter

        // Load sample data
        loadNotifications()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun loadNotifications() {
        notificationList.add(NotificationItem("Fire Drill", "2024-01-15", "Monthly fire drill scheduled"))
        notificationList.add(NotificationItem("Flood Warning", "2024-01-14", "Heavy rain expected"))
        notificationAdapter.notifyDataSetChanged()
    }
}