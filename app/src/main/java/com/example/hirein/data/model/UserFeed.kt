package com.example.hirein.data.model

data class UserFeed(
    val userId:Long,
    val posts : List<JobPostData>
)
