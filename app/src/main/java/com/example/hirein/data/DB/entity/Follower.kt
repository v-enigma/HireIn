package com.example.hirein.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "follower",
    primaryKeys = ["userId", "followerId"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["followerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Follower(
    val userId: Long,
    val followerId: Long
)
