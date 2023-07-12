package com.example.hirein.data.entity

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
data class jobRequirement(
    val jobPostId :Long,
    val requirement: String
) {
    @PrimaryKey(autoGenerate = true)
    val requirementId: Long = 0
}