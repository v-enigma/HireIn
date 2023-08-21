package com.example.hirein.data

import androidx.lifecycle.ViewModel

data class ConnectionInformation(
    val id : Long,
    val firstName:String,
    val lastName: String,
    val companyName:String,
    val  profilePhoto: String,
    val roleName:String
):ViewModel()
