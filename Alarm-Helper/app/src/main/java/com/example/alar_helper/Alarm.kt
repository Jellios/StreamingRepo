package com.example.alar_helper

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "alarms")
    data class  Alarm(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val time: String,
        val daysOfWeek: String,
        val label: String,
        val sound: String,
        val snoozeDuration: Int,
        var isActive: Boolean = true)
