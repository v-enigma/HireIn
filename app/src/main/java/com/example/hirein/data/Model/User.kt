package com.example.hirein.data.Model

data class User(
       val userId:String,
       val userDetails: UserDetails,
       val educationalQualifications: List<EducationalQualification>,
       val experiences:  List <ProfessionalExperience>,
       val following: List<String>)
