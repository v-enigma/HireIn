package com.example.hirein.data.DB.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    primaryKeys = ["userId", "jobPostId"],
    foreignKeys = [
        ForeignKey(
            entity= User::class,
            parentColumns = ["userId"],
            childColumns =["userId"],
            onDelete = ForeignKey.CASCADE
        ),
    ForeignKey(
        entity = JobPost::class,
        parentColumns = ["jobPostId"],
        childColumns = ["jobPostId"],
        onDelete = ForeignKey.CASCADE
    )
    ]
)
data class AppliedJobs(
    val userId:Long,
    val jobPostId :Long
)
