package com.example.hirein.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserIdViewModel: ViewModel() {
    private var _userId = MutableLiveData<Long>()
    val userId: LiveData<Long>
    get() = _userId

    fun setUserId(id: Long){
        _userId.value = id
    }

}