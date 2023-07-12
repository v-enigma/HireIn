package com.example.hirein.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Company(
    @PrimaryKey(autoGenerate = true)
    val companyId: Long =0,
    val name:String,
    val website: String,
    val minEmployeeCount :Int? = null,
    val maxEmployeeCount :Int? = null,
)
