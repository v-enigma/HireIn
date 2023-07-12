package com.example.hirein.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = JobPost::class,
            parentColumns = ["jobPostId"],
            childColumns = ["jobPostId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Field(
    @PrimaryKey(autoGenerate = true)
    val fieldId: Long,
    val jobPostId :Long,
    val Name:String,
    val dataType :String,
    val Index:Int)