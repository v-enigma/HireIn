package com.example.hirein.data.entity

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
           parentColumns = ["CompanyId"],
           childColumns = ["companyId"],
           onDelete = ForeignKey.CASCADE
       )
    ]
)
data class JobPost(
    val postOwnerId : Long,
    val jobTitle : String,
    val Industry :String,
    val minExperience : Int,
    val maxExperience: Int?,
    val employmentType: String,
    val minSalary :Int,
    val maxSalary: Int,
    val companyId :Long,
//    val tags :List<String>,
    val locationType : String,
    val workLocation : String?,
    //val jobRequirements : List<String>,
    //val jobSkills  : List<String>,
    val postedDate: Long,
    val applicationStatus : String
){
    @PrimaryKey(autoGenerate = true)
    val jobPostId: Long = 0
}
