package com.example.hirein.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hirein.data.entity.JobPost
import com.example.hirein.data.model.JobPostData
import java.time.LocalDate

class JobPostViewModel() :ViewModel() {

    private val posts = listOf<JobPostData>(
         JobPostData(1,1,"Venugopal T","","Android Engineer", "Engineering",1,2,
             "FullTime",800000,1200000,1,"Zoho", listOf(),"Remote","Chennai", listOf("User should have experience in kotlin","User is good knowledge of oops and design patterns"),
             listOf("kotlin","OOPS","Java","MVVM"),LocalDate.now().toEpochDay(),"Open")
         ,
    JobPostData(2,1,"Venugopal T","","Software Engineer", "Engineering/IT",1,2,
    "FullTime",800000,1200000,1,"Zoho", listOf(),"Remote","Chennai", listOf("User should have experience in kotlin","User is good knowledge of oops and design patterns"),
    listOf("kotlin","OOPS","Java","MVVM"),LocalDate.now().toEpochDay(),"Open"),
    JobPostData(3,1,"Venugopal T","","FullStack Developer", "Engineering/IT",1,2,
        "FullTime",800000,1200000,1,"Zoho", listOf(),"Remote","Chennai", listOf("User should have experience in kotlin","User is good knowledge of oops and design patterns"),
        listOf("kotlin","OOPS","Java","MVVM"),LocalDate.now().toEpochDay(),"Open"),
    JobPostData(4,1,"Venugopal T","","BackEnd Developer", "Engineering/IT",1,2,
        "FullTime",800000,1200000,1,"Zoho", listOf(),"Remote","Chennai", listOf("User should have experience in kotlin","User is good knowledge of oops and design patterns"),
        listOf("kotlin","OOPS","Java","MVVM"),LocalDate.now().toEpochDay(),"Open"),
    JobPostData(2,1,"Venugopal T","","IOS Developer", "Engineering/IT",1,2,
        "FullTime",800000,1200000,1,"Zoho", listOf(),"Remote","Chennai", listOf("User should have experience in kotlin","User is good knowledge of oops and design patterns"),
        listOf("kotlin","OOPS","Java","MVVM"),LocalDate.now().toEpochDay(),"Open")
    )


    private val _jobPost = MutableLiveData<List<JobPostData>>()
    val jobPost : LiveData<List<JobPostData>> get() = _jobPost

    fun getData(): LiveData<List<JobPostData>>{
        if(_jobPost.value == null){
            _jobPost.value = posts
        }
        return jobPost
    }

}