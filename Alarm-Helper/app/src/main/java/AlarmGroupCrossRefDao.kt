package com.example.alar_helper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlarmGroupCrossRefDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun
            insertAlarmGroupCrossRef(crossRef: AlarmGroupCrossRef)

    @Query("DELETE FROM AlarmGroupCrossRef WHERE alarmId = :alarmId AND groupId = :groupId")
    suspend fun deleteAlarmGroupCrossRef(alarmId: Int, groupId: Int)

    @Query("SELECT * FROM AlarmGroupCrossRef WHERE groupId = :groupId")
    fun getAlarmsInGroup(groupId: Int): LiveData<List<AlarmGroupCrossRef>>
}