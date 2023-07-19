package com.example.hirein.data.entity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class JobPostViewModelFactory(private val dao : JobPostDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }
}