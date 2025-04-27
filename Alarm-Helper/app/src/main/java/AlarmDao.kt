package com.example.alar_helper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface AlarmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun
    InsertAlarm(alarm: Alarm)
    @Update
    suspend fun
            updateAlarm(alarm: Alarm)

    @Query("DELETE FROM alarms WHERE id = :alarmId")
    suspend fun deleteAlarm(alarmId: Int)

    @Query("SELECT * FROM alarms")
    fun getAllAlarms(): LiveData<List<Alarm>>

    @Query("SELECT * FROM alarms WHERE id = :alarmId")
    fun getAlarmById(alarmId: Int): LiveData<Alarm>

}