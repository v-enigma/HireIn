package com.example.hirein.data.model

import com.example.hirein.data.entity.Address
import com.example.hirein.data.entity.EmploymentType
import java.time.LocalDate

data class professionalExperience(
    val  title :String,
    val employemeType: EmploymentType,
    val location: Address,
    val description: List<String>,
    val startDate: LocalDate,
    val skills : List<String>,
    val endDate: LocalDate)
