package com.example.hirein.data.Model

import android.location.Address
import java.time.LocalDate

data class ProfessionalExperience(
    val title:String,
    val employementType: EmployementType,
    val company: Company,
    val location:Address,
    val startDate :LocalDate,
    val endDate : LocalDate?,
    val skills : List<String>) {
}