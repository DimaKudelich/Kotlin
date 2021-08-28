package com.kudelich.bsu.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kudelich.bsu.classes.entities.Class

@Dao
interface ClassDao {
    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun addClass(classes: Class)

    @Query("SELECT * FROM classes_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Class>>
}