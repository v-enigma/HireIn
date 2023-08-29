package com.example.hirein.ui

import com.example.hirein.data.model.JobPostData

interface DataUpdateListener {
    fun onUpdate(newData: List<JobPostData>)
}