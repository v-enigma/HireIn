package com.example.hirein.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirein.data.db.JobPostRepository
import com.example.hirein.data.model.JobPostData
import com.example.hirein.data.model.UserFeed
import kotlinx.coroutines.*

class JobPostsViewModel(

    private val repository: JobPostRepository,

    val userId: Long
) : ViewModel() {
    //var isEnabled = true
     var index = -1

    lateinit var jobsFeed: MutableList<JobPostData>

    fun initializeJobsFeed(bindingAdapter: () ->Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                jobsFeed = repository.getJobPosts(userId)
                bindingAdapter()
            }
        }
    }
    fun applyToJob(userId: Long, jobPostId: Long,  position :Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.applyToJob(userId,jobPostId)
                jobsFeed.removeAt(position)

            }
        }
    }

}