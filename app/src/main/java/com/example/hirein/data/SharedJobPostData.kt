package com.example.hirein.data

import androidx.lifecycle.ViewModel
import com.example.hirein.data.model.JobPostData

class SharedJobPostData:ViewModel() {
     lateinit var jobPostData: JobPostData
}