package com.example.alar_helper

import androidx.room.Entity
@Entity(primaryKeys = ["alarmId", "groupId"])
data class AlarmGroupCrossRef (
    val alarmId: Int,
    val groupId: Int
)
