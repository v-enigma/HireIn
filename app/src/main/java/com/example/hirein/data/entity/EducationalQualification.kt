package com.example.hirein.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
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
    val userId:Long,
    val instituteName:String,
    val degree:String,
    val specialization:String,
    val startDate: Long,
    val endDateOrExpectedEndDate: Long,
    val grade: Float,
    val description:String){
    @PrimaryKey(autoGenerate = true)
    val instituteId: Long = 0
}
