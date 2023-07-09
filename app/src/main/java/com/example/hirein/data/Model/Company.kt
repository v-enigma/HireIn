package com.example.hirein.data.Model

data class Company(
    val name:String,
    val website: String,
    val minEmployeeCount :Int,
    val maxEmployeeCount :Int?,
    val address: List<Address>
)
