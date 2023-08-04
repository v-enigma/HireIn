package com.example.hirein.data.DB.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
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

    val postedDate: Long,
    val applicationStatus : String
)
