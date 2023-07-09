package com.example.hirein.data.Model

data class UserActivity(
    val userId:String,
    val appliedJobs: List<String>,
    val following : List<String>)
