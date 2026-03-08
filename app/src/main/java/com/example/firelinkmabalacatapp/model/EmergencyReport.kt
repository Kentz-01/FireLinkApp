package com.example.firelinkmabalacatapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmergencyReport(
    val fullName: String,
    val contactNumber: String,
    val emergencyType: String,
    val description: String,
    val latitude: Double,
    val longitude: Double,
    val referenceNumber: String
) : Parcelable