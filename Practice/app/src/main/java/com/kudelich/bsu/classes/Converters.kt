package com.kudelich.bsu.classes

import com.kudelich.bsu.classes.entities.Faculty

class Converters {
    fun toStringList(faculties: List<Faculty>): List<String>{
        var list = mutableListOf<String>()

        for(faculty in faculties){
            list.add(faculty.name)
        }

        return list
    }
}