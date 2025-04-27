package com.example.alar_helper

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
@Dao
interface AlarmGroupDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insertGroup(group: AlarmGroup)

    @Update
    suspend fun
            updateGroup(group: AlarmGroup)
    @Query("DELETE FROM alarm_groups WHERE id = :groupId")
    suspend fun deleteGroup(groupId: Int)

    @Query("SELECT * FROM alarm_groups")
    fun getAllGroups(): LiveData<List<AlarmGroup>>

    @Query("SELECT * FROM alarm_groups WHERE id = :groupId")
    fun getGroupById(groupId: Int) : LiveData<AlarmGroup>
}