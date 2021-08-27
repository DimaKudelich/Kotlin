package com.kudelich.bsu.data.repository

import androidx.lifecycle.LiveData
import com.kudelich.bsu.data.dao.FacultyDao
import com.kudelich.bsu.entities.database.Faculty

class FacultyRepository(private val facultyDao: FacultyDao) {
    val readAllData: LiveData<List<Faculty>> = facultyDao.readAllData()

    suspend fun addFaculty(faculty: Faculty){
        facultyDao.addFaculty(faculty)
    }
}