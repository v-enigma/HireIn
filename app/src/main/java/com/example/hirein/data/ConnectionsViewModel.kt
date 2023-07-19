package com.example.hirein.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


@RequiresApi(Build.VERSION_CODES.O)
class ConnectionsViewModel:ViewModel() {
    private val connections = listOf(
        ConnectionInfromation(1,"R","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(2,"Ravan","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(3,"Raj","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(4,"kumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(5,"Rar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(6,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(7,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(8,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(9,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(10,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(11,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(12,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(13,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(14,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(15,"Rajkumar","V", "Zoho", " ", "MTS"),
        ConnectionInfromation(16,"Rajkumar","V", "Zoho", " ", "MTS")
    )

    private var _followers = MutableLiveData<List<ConnectionInfromation>>()



    val followers : LiveData<List<ConnectionInfromation>> get() = _followers


     fun getData():LiveData<List<ConnectionInfromation>>{
       if(_followers.value == null){
           _followers.value = connections
       }
        return followers

    }
    fun deleteFollower(position:Int){
        val currentFollowers = _followers.value?.toMutableList()
        val count  = currentFollowers?.size ?: -1
        println("Count is $count")
        if(count > 0 && position < count ) {
            currentFollowers?.removeAt(position)
        }
        _followers.value = currentFollowers?.toList()
        println("I am inside the delete ${_followers.value?.size}")
        println("${_followers.value}")
    }


}