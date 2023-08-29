package com.example.hirein.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserIdViewModel: ViewModel() {
    private var _userId = MutableLiveData<Long>()
    val userId: Long
    get() = _userId.value!!

    fun setUserId(id: Long){
        _userId.value = id
    }

}