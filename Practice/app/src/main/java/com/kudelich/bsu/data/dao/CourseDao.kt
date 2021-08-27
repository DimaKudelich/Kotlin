package com.kudelich.bsu.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kudelich.bsu.entities.database.Course

@Dao
interface CourseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCourse(course: Course)

    @Query("SELECT * FROM courses_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Course>>
}