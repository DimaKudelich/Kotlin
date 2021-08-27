package com.kudelich.bsu.entities.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups_table")
data class Group(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val number: Int,
    val name: String,
    val courseId: Int
)
