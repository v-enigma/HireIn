package com.example.hirein.data.DB.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(
    foreignKeys = [
        ForeignKey(entity = JobPost::class,
         parentColumns = ["jobPostId"],
        childColumns = ["jobPostId"],
        onDelete = ForeignKey.CASCADE)
    ]
)
data class Tag(
    val jobPostId: Long,
    val tag :String,
    @PrimaryKey(autoGenerate = true)
    val tagId :Long = 0)

