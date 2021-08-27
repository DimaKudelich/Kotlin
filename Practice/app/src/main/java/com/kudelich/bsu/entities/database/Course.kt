package com.kudelich.bsu.entities.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses_table")
data class Course(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val number: Int,
    val facultyId: Int
)
