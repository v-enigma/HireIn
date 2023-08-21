package com.example.hirein.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "educationalQualification",
    foreignKeys = [
        ForeignKey (
                entity = User::class,
                parentColumns = ["userId"],
                childColumns = ["userId"],
                onDelete = ForeignKey.CASCADE
        )
    ]
)
data class EducationalQualification(
    @PrimaryKey(autoGenerate = true)
    val instituteId: Long = 0,
    val userId:Long,
    val instituteName:String,
    val degree:String,
    val specialization:String,
    val startDate: Date,
    val studyingNow : Boolean,
    val endDateOrExpectedEndDate: Date?,
    val grade: Float,
    val description:String)
