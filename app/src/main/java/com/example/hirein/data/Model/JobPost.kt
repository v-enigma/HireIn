package com.example.hirein.data.Model

import java.time.LocalDate
import java.time.LocalTime

data class JobPost(
    val jobPostId: String,
    val postOwnerId : String,
    val jobTitle : String,
    val Industry :String,
    val minExperience : Int,
    val maxExperience: Int?,
    val employementType: EmployementType,
    val companyId :String,
    val tags :List<String>,
    val locationType : LocationType,
    val workLocation : String?,
    val jobRequirements : List<String>,
    val jobSkills  : List<String>,
    val postedDate: LocalDate,
    val postedTime : LocalTime,
    val applicationStatus : ApplicationStatus
)
