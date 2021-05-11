package com.github.twotothe10th.homeworkproject.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val description: String,
    val date: String,
    @ColumnInfo(name = "image_uri") val imageUri: String)
