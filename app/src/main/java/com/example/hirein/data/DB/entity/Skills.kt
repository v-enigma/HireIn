package com.example.hirein.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "skills",
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
    val name :String,
    @PrimaryKey(autoGenerate = true)
    val skillId: Long = 0,
)
