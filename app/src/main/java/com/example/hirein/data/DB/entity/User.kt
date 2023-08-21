package com.example.hirein.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="userId")
    val userId: Long =0,
    @ColumnInfo(name = "firstName")
    val firstName:String,
    @ColumnInfo(name = "lastName")
    val lastName:String,
    @ColumnInfo(name = "mobileNo")
    val mobileNo :String,
    @ColumnInfo(name ="emailId")
    val emailId:String,
    @ColumnInfo(name="dateOfBirth")
    val dateOfBirth: Date,
    @ColumnInfo(name="profilePhoto")
    val profilePhoto: String,
    @ColumnInfo(name="password")
    val password: String
    /*val educationalQualifications: List<EducationalQualification>,
    val experiences:  List <ProfessionalExperience>,
    val following: List<String>*/
)
