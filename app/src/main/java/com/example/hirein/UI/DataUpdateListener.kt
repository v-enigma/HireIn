package com.example.hirein.UI

import com.example.hirein.data.model.JobPostData

interface DataUpdateListener {
    fun onUpdate(newData: List<JobPostData>)
}