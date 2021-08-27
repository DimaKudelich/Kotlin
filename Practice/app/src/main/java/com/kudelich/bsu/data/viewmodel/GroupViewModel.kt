package com.kudelich.bsu.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kudelich.bsu.data.AppDatabase
import com.kudelich.bsu.data.repository.GroupRepository
import com.kudelich.bsu.entities.database.Group
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GroupViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Group>>
    private val repository: GroupRepository

    init{
        val dao = AppDatabase.getAppDatabase(application,viewModelScope).groupDao()
        repository = GroupRepository(dao)
        readAllData = repository.readAllData
    }

    fun addFaculty(group: Group){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGroup(group)
        }
    }
}