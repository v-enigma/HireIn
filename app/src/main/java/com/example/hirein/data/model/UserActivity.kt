package com.example.hirein.data.model

data class UserActivity(
    val userId: String,
    val appliedJobs : List<Long>,
    val postMade : List<JobPostData>
)
