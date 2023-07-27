package com.example.hirein.data.model

import android.os.Parcelable

data class JobPostData(
    val postId:Long,
    val postOwnerId : Long,
    val postOwnerName:String,
    val postOwnerImage:String?,
    val jobTitle : String,
    val Industry :String,
    val minExperience : Int,
    val maxExperience: Int?,
    val employmentType: String,
    val minSalary :Int,
    val maxSalary: Int,
    val companyId :Long,
    val companyName: String,
    val tags :List<String>,
    val locationType : String,
    val workLocation : String?,
    val jobRequirements : List<String>,
    val jobSkills  : List<String>,
    val postedDate: Long,
    val applicationStatus : String
)