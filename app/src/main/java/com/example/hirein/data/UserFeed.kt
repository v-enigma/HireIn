package com.example.hirein.data

import com.example.hirein.data.entity.JobPost


data class UserFeed(
    val userId:String,
    val posts: List<JobPost>)