package com.kudelich.bsu.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kudelich.bsu.entities.database.Faculty

@Dao
interface FacultyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFaculty(faculty: Faculty)

    @Query("SELECT * FROM faculties_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Faculty>>
}