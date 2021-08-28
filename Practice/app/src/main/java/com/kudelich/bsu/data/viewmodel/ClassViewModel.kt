package com.kudelich.bsu.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kudelich.bsu.data.AppDatabase
import com.kudelich.bsu.data.repository.ClassRepository
import com.kudelich.bsu.classes.entities.Class
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClassViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Class>>
    private val repository: ClassRepository
    
    init{
        val dao = AppDatabase.getAppDatabase(application,viewModelScope).classDao()
        repository = ClassRepository(dao)
        readAllData = repository.readAllData
    }

    fun addClass(classes: Class){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addClass(classes)
        }
    }
}