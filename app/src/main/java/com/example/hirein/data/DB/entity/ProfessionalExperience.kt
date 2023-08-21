package com.example.hirein.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "professionalExperience",
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
    val role :String,
    val employmentType:String,
    val companyId: Long,
    val locationId:Long,
    val startDate : Date,
    val endDate : Date?,
    val currentlyWorking :Boolean) {
    @PrimaryKey(autoGenerate = true)
    var rowId : Long = 0
}