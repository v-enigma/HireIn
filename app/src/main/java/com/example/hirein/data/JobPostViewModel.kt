package com.example.hirein.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hirein.data.DB.entity.JobPost
import com.example.hirein.data.model.JobPostData
import java.time.LocalDate

class JobPostViewModel(

) :ViewModel() {
    private val _jobPost = MutableLiveData<List<JobPostData>>()
    val jobPost : LiveData<List<JobPostData>> get() = _jobPost
    fun getData(): LiveData<List<JobPostData>>{
        if(_jobPost.value == null){
            //_jobPost.value =
        }
        return jobPost
    }
}