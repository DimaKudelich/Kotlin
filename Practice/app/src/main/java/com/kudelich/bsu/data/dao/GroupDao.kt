package com.kudelich.bsu.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kudelich.bsu.entities.database.Group

@Dao
interface GroupDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addGroup(group: Group)

    @Query("SELECT * FROM groups_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Group>>
}