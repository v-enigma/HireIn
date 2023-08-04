package com.example.hirein.data.DB.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = JobPost::class,
            parentColumns = ["jobPostId"],
            childColumns =["jobPostId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Skills(
    val jobPostId : Long,
    @PrimaryKey(autoGenerate = true)
    val skillId: Long,
    val name :String
)
