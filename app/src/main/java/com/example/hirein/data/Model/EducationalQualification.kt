package com.example.hirein.data.Model

import java.time.LocalDate

data class EducationalQualification(
    val instituteName:String,
    val degree: String,
    val sepecialization:String,
    val startDate: LocalDate,
    val endDateOrExpectedEndDate:LocalDate?,
    val grade:Float = 0.0f,
    val description:String) {
}