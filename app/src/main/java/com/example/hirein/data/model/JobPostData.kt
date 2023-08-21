package com.example.hirein.data.model

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.hirein.data.db.entity.Company

data class JobPostData(
    val postId:Long,
    val postOwnerDetails: PostOwnerDetails,
    val jobTitle : String,
    val Industry :String,
    val minExperience : Int,
    val maxExperience: Int?,
    val employmentType: String,
    val minSalary :Int,
    val maxSalary: Int,
    val company: Company,
    val tags :List<String>,
    val locationType : String,
    val workLocation : String?,
    val jobRequirements : List<String>,
    val jobSkills : List<String>,
    val postedDate: Long,
    val applicationStatus : String
): ViewModel()
data class PostOwnerDetails(
    val userId : Long,
    val role : String?,
    val firstName:String,
    val lastName:String,
    val profilePhoto:String?,
)