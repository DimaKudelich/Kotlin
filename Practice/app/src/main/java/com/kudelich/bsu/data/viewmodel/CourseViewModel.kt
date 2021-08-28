package com.kudelich.bsu.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kudelich.bsu.data.AppDatabase
import com.kudelich.bsu.data.repository.CourseRepository
import com.kudelich.bsu.classes.entities.Course
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CourseViewModel (application: Application): AndroidViewModel(application){
    val readAllData: LiveData<List<Course>>
    private val repository: CourseRepository

    init{
        val dao = AppDatabase.getAppDatabase(application,viewModelScope).courseDao()
        repository = CourseRepository(dao)
        readAllData = repository.readAllData
    }

    fun addGroup(course: Course){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCourse(course)
        }
    }
}