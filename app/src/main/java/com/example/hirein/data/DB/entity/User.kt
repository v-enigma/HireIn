package com.example.hirein.data.DB.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Long =0,
    val firstName:String,
    val lastName:String,
    val mobileNo :String,
    val emailId:String?,
    val DateOfBirth: Long,
    val profilePhoto: String,
    val password: String
    /*val educationalQualifications: List<EducationalQualification>,
    val experiences:  List <ProfessionalExperience>,
    val following: List<String>*/
)
