package com.kudelich.bsu.data.repository

import androidx.lifecycle.LiveData
import com.kudelich.bsu.data.dao.CourseDao
import com.kudelich.bsu.classes.entities.Course

class CourseRepository(private val courseDao: CourseDao) {
    val readAllData: LiveData<List<Course>> = courseDao.readAllData()

    suspend fun addCourse(course: Course){
        courseDao.addCourse(course)
    }
}