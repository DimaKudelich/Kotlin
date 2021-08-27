package com.kudelich.bsu.entities.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classes_table")
data class Class(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val time: String,
    val subject: String,
    val place: String,
    val groupId: Int
)
