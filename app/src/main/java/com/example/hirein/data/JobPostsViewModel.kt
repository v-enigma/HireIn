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
    private var _jobsFeed = MutableLiveData<MutableList<JobPostData>>()
    val jobsFeed :LiveData<MutableList<JobPostData>> = _jobsFeed
    fun initializeJobsFeed() {
        //println("I am  entering Intialization PPP")
        viewModelScope.launch {
            println("I am coroutine PPP")
            withContext(Dispatchers.IO) {
                val jobFeed =  repository.getJobPosts(userId)
                _jobsFeed.postValue (jobFeed)

            }
        }
    }
    fun applyToJob(userId: Long, jobPostId: Long,  position :Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.applyToJob(userId,jobPostId)
                jobsFeed.value?.removeAt(position)

            }
        }
    }

}