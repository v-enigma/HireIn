package com.example.hirein.data.entity

import androidx.room.Entity
import java.time.LocalDate


@Entity(tableName = "user")
data class User(
    val userId: Long,
    val firstName:String,
    val lastName:String,
    val mobileNo :String,
    val emailId:String?,
    val DateOfBirth: LocalDate,
    val profilePhoto: String,
    val password: String
    /*val educationalQualifications: List<EducationalQualification>,
    val experiences:  List <ProfessionalExperience>,
    val following: List<String>*/
)
