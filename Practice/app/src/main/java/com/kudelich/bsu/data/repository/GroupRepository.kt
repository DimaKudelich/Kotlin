package com.kudelich.bsu.data.repository

import androidx.lifecycle.LiveData
import com.kudelich.bsu.data.dao.GroupDao
import com.kudelich.bsu.classes.entities.Group

class GroupRepository(private val groupDao: GroupDao) {
    val readAllData: LiveData<List<Group>> = groupDao.readAllData()

    suspend fun addGroup(group: Group){
        groupDao.addGroup(group)
    }
}