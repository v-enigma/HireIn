package com.example.hirein.data.model

import java.time.LocalDate

data class UserDetails(
    val firstName:String,
    val lastName:String,
    val mobileNo:String,
    val emailId:String?,
    val dateOfBirth: LocalDate,
    val profilePicture: String
)
