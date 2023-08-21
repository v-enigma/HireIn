package com.example.hirein.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(tableName = "tag",
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

