package com.example.hirein.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.hirein.data.db.ConnectionRepository
import com.example.hirein.data.db.JobPostRepository

class JobPostViewModelFactory(private val jobPostRepository: JobPostRepository, private val userId: Long ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(JobPostsViewModel::class.java)){
            return JobPostsViewModel(jobPostRepository, userId) as T
        }
        throw IllegalArgumentException("Unkown ViewModel class")
    }
}

class SharedJobPostViewModelFactory(private val jobPostRepository: JobPostRepository,private val userId: Long):ViewModelProvider.Factory{
    override fun<T: ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(SharedJobPostData::class.java)){
            return SharedJobPostData(jobPostRepository,userId) as T
        }
        throw  IllegalArgumentException("Unkown ViewModel class")
    }
}
class ConnectionViewModelFactory(private val connectionRepository: ConnectionRepository, private val userId: Long): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ConnectionsViewModel::class.java)){
            return ConnectionsViewModel(connectionRepository,userId) as T
        }
        throw IllegalArgumentException("Unkonw viewModal Class")
    }
}


