package com.example.hirein.data.Model

data class UserFeed(
    val userId:String,
    val posts: List<JobPost>)