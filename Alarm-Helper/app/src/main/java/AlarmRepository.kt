package com.example.alar_helper

import androidx.lifecycle.LiveData

class AlarmRepository (private val alarmDao: AlarmDao) {
    val allAlarms: LiveData<List<Alarm>> = alarmDao.getAllAlarms()

    suspend fun insertAlarm(alarm: Alarm) {
        alarmDao.InsertAlarm(alarm)
    }
    suspend fun updateAlarm(alarm: Alarm) {
        alarmDao.updateAlarm(alarm)
    }

    suspend fun deleteAlarm(alarmId: Int) {
        alarmDao.deleteAlarm(alarmId)
    }

    fun getAlarmById(alarmId: Int): LiveData<Alarm> {
        return alarmDao.getAlarmById(alarmId)
    }
}