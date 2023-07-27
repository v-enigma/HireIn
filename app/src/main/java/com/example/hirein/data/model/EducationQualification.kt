package com.example.hirein.data.model

import java.time.LocalDate

data class EducationQualification(
    val instituteName : String,
    val degree : String,
    val specialization: String,
    val startDate: LocalDate,
    val endDateOrExpectedEndDate: LocalDate?,
    val grade: Float?,
    val description :String
)
