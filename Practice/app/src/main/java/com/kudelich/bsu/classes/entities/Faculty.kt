package com.kudelich.bsu.classes.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "faculties_table")
data class Faculty(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
