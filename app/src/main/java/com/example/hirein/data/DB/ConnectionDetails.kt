package com.example.hirein.data.db

data class ConnectionDetails(
    val userId: Long,
    val firstName: String,
    val lastName:String,
    val profilePhoto: String?,
)
data class ConnectionProfessionalDetails(
    val name:String,
    val role :String
)
