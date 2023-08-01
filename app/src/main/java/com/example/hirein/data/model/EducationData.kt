package com.example.hirein.data.model

import java.time.LocalDate

data class EducationData(
    val instituteName : String,
    val degree : String,
    val specialization: String,
    val startDate: Long,
    val endDateOrExpectedEndDate: Long?,
    val grade: Float?,
    val description :String
)
