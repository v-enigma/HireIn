package com.example.hirein.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ,ForeignKey(
            entity = Company::class,
            parentColumns = ["companyId"],
            childColumns = ["companyId"],
            onDelete = ForeignKey.CASCADE
    )
     ]
)
data class ProfessionalExperience(
    val userId:Long,
    val title:String,
    val employmentType:String,
    val companyId: Long,
    val locationId:Long,
    val startDate :Long,
    val endDate : Long) {
    @PrimaryKey(autoGenerate = true)
    var rowId : Long = 0
}