package com.example.alar_helper
import androidx.room.Entity
import androidx.room.PrimaryKey


    @Entity(tableName = "alarm_groups")
    data class  AlarmGroup(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val name: String,
       var isActive: Boolean = true
    )
