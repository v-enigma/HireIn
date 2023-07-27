package com.example.hirein.data.model

data class UserActivity(
    val userId: String,
    val AppliedJobs : List<Long>,
    val postMade : List<Long>
)
