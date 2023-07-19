package com.example.hirein.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hirein.data.entity.JobPost

class JobPostViewModel() :ViewModel( ) {

    private val posts = listOf<JobPost>(
        JobPost(1,"Android Developer","Engineering/IT",0,2,"FullTime", 600000,1000000,1, "Hybrid","Chennai",
            System.currentTimeMillis(),"Open"),
        JobPost(1,"Android Developer","Engineering/IT",0,2,"FullTime", 600000,1000000,1, "Hybrid","Chennai",
            System.currentTimeMillis(),"Open"),
        JobPost(1,"Android Developer","Engineering/IT",0,2,"FullTime", 600000,1000000,1, "Hybrid","Chennai",
            System.currentTimeMillis(),"Open"),
        JobPost(1,"Android Developer","Engineering/IT",0,2,"FullTime", 600000,1000000,1, "Hybrid","Chennai",
            System.currentTimeMillis(),"Open")
    )

    private val _jobPost = MutableLiveData<List<JobPost>>()
    val jobPost : LiveData<List<JobPost>> get() = _jobPost

    fun getData(): LiveData<List<JobPost>>{
        if(_jobPost.value == null){
            _jobPost.value = posts
        }
        return jobPost
    }

}