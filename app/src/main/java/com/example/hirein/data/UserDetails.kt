package com.example.hirein.data

import java.net.URL
import java.time.LocalDate

data class UserDetails(
     val firstName:String,
     val lastName:String,
     val mobileNo :String,
     val emailId:String?,
     val DateOfBirth: LocalDate,
     val profilePhoto: String) {

}