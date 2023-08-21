package com.example.hirein.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirein.data.db.JobPostRepository
import com.example.hirein.data.model.JobPostData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SharedJobPostData(
     val repository: JobPostRepository, val userId:Long):ViewModel() {
     lateinit var jobPostData: JobPostData


     fun applyToJob(userId: Long, jobPostId: Long, uiUpdate: () ->Unit, bindingAdapter: () -> Unit){
          viewModelScope.launch {
               withContext(Dispatchers.IO){
                    repository.applyToJob(userId,jobPostId)
                    //isEnabled = false
                    uiUpdate()
                    //initializeJobsFeed(bindingAdapter)
               }
          }
     }
}