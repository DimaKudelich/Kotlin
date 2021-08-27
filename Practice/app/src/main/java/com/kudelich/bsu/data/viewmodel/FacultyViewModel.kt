package com.kudelich.bsu.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kudelich.bsu.data.AppDatabase
import com.kudelich.bsu.data.repository.FacultyRepository
import com.kudelich.bsu.entities.database.Faculty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FacultyViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<Faculty>>
    private val repository: FacultyRepository

    init{
        val dao = AppDatabase.getAppDatabase(application,viewModelScope).facultyDao()
        repository = FacultyRepository(dao)
        readAllData = repository.readAllData
    }

    fun addFaculty(faculty: Faculty){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFaculty(faculty)
        }
    }
}