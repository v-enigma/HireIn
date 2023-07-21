package com.example.hirein.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ConnectionsViewModel:ViewModel() {
      private  var _searchResults = MutableLiveData<MutableList<ConnectionInfromation>>()
       var searchResults :MutableLiveData<MutableList<ConnectionInfromation>> = _searchResults
       private var accessedOnce = false
      init{
          println("connections ViewModel creation")


      }
    companion object{
       fun initialize(size :Int ,deletedList: MutableList<Boolean>){
           var i = size
           while(i > 0){
              deletedList.add(true)
               i--
           }
       }
    }

       private  var connections = listOf(
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
    private val deletedList = mutableListOf<Boolean>()


    private var _followers = MutableLiveData<List<ConnectionInfromation>>()
    val followers : LiveData<List<ConnectionInfromation>> get() = _followers
     fun getData():LiveData<List<ConnectionInfromation>>{
       initialize(connections.size,deletedList)
       if(_followers.value == null){
          _followers.value =  setValues()
       }
        return followers
    }
    fun setValues():List<ConnectionInfromation>{
        val list = mutableListOf<ConnectionInfromation>()
        var index =0
        deletedList.forEach{
           if(it){
               list.add(connections[index])
           }
            index++
        }
        return list.toList()
    }
    fun deleteFollower(position:Int){
        println("$position is position")
        val currentFollowers = _followers.value?.toMutableList()

        val count  = currentFollowers?.size ?: -1
        var index =0
        println("Count is $count")
        if(count > 0 && position < count ) {
             val user =  currentFollowers?.removeAt(position)

            connections.forEach {
                if( it.id == user?.id ) {
                    deletedList[index] = false
                    _followers.value = setValues()
                    return
                }
                index++
            }
        }
    }
    fun search(searchText: String?):List<ConnectionInfromation>{
        println("$deletedList")
        _searchResults.value = setValues().toMutableList()
        println("I am inside method search")
//        if(!accessedOnce) {
//            _searchResults.value = setValues().toMutableList()
//            accessedOnce = true
//        }
       println("Inside search")
        val results = mutableListOf<ConnectionInfromation>()

        if(searchText?.isEmpty() == true){
            _followers.value = setValues()
        }
        else {

            searchText?.let {
                _searchResults.value?.forEach {
                    println(it)
                    if ( it.firstName.contains(
                            searchText ,
                            true
                        ) || it.lastName.contains(searchText, true )||
                        ( it.firstName+" "+it.lastName).contains(searchText, true)
                        )
                     {
                        results.add(it)
                        println("Successful")
                    }
                }
            }
            _followers.value = results
        }
     println("$results")
    return results
    }

}