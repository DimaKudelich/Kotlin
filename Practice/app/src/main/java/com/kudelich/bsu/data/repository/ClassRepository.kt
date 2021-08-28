package com.kudelich.bsu.data.repository

import androidx.lifecycle.LiveData
import com.kudelich.bsu.data.dao.ClassDao
import com.kudelich.bsu.classes.entities.Class

class ClassRepository(private val classDao: ClassDao) {
    val readAllData: LiveData<List<Class>> = classDao.readAllData()

    suspend fun addClass(classes: Class){
        classDao.addClass(classes)
    }
}