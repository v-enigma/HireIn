package com.example.hirein.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
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
