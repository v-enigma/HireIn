package com.example.hirein.data.model

import com.example.hirein.data.entity.EducationalQualification
import com.example.hirein.data.entity.ProfessionalExperience

data class UserProfileData(
    val userId: Long,
    val userDetails :UserDetails,
    val educationalQualifications :List<EducationalQualification>,
    val experience : List<ProfessionalExperience>,
    val following: List<Long>
)
