package com.example.hirein.data.model

import com.example.hirein.data.db.entity.Address
import com.example.hirein.data.db.entity.Company
import com.example.hirein.data.db.entity.EmploymentType
import java.time.LocalDate

data class ProfessionalExperienceData(
    val  title :String,
    val  company: Company,
    val employemeType: EmploymentType,
    val location: Address,
    val description: List<String>,
    val startDate: LocalDate,
    val skills : List<String>,
    val endDate: LocalDate)

