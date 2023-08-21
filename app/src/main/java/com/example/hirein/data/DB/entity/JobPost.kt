package com.example.hirein.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "jobPost",
    foreignKeys = [
        ForeignKey(
           entity = User::class,
           parentColumns = ["userId"],
           childColumns = ["postOwnerId"],
           onDelete = ForeignKey.CASCADE
        ),
       ForeignKey(
           entity = Company::class,
           parentColumns = ["companyId"],
           childColumns = ["companyId"],
           onDelete = ForeignKey.CASCADE
       )
    ]
)
data class JobPost(
    @PrimaryKey(autoGenerate = true)
    val jobPostId: Long = 0,
    val postOwnerId : Long,
    val postOwnerRole: String,
    val jobTitle : String,
    val Industry :String,
    val minExperience : Int,
    val maxExperience: Int?,
    val employmentType: String,
    val minSalary :Int,
    val maxSalary: Int,
    val companyId :Long,
    val locationType : String,
    val workLocation : String?,
    val postedDate: Date,
    val applicationStatus : String
)
