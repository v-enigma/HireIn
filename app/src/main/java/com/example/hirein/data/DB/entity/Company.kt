package com.example.hirein.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "company")
data class Company(
    @PrimaryKey(autoGenerate = true)
    val companyId: Long,
    val name:String,
    val website: String,
    val minEmployeeCount :Int? = null,
    val maxEmployeeCount :Int? = null,
)
