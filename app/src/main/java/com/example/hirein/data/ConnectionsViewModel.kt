package com.example.hirein.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ConnectionsViewModel:ViewModel() {
      private  var _searchResults = MutableLiveData<MutableList<ConnectionInformation>>()
       //var searchResults :MutableLiveData<MutableList<ConnectionInformation>> = _searchResults


    companion object{
       fun initialize(size :Int ,deletedList: MutableList<Boolean>){
           //println("Calling the initialize function_________________________________________")
           var i = size
           while(i > 0){
              deletedList.add(true)
               i--
           }
       }
    }

       private  var connections = listOf(
            ConnectionInformation(1,"R","V", "Zoho", " ", "MTS"),
            ConnectionInformation(2,"Ravan","V", "Zoho", " ", "MTS"),
            ConnectionInformation(3,"Raj","V", "Zoho", " ", "MTS"),
            ConnectionInformation(4,"kumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(5,"Rar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(6,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(7,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(8,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(9,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(10,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(11,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(12,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(13,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(14,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(15,"Rajkumar","V", "Zoho", " ", "MTS"),
            ConnectionInformation(16,"Rajkumar","V", "Zoho", " ", "MTS")
        )
    private val deletedList = mutableListOf<Boolean>()


    private var _followers = MutableLiveData<List<ConnectionInformation>>()
    val followers : LiveData<List<ConnectionInformation>> get() = _followers
     fun getData():LiveData<List<ConnectionInformation>>{
       initialize(connections.size,deletedList)
       if(_followers.value == null){
          _followers.value =  setValues()
       }
        return followers
    }
    fun setValues():List<ConnectionInformation>{
        val list = mutableListOf<ConnectionInformation>()
        var ind =0
        println("${deletedList.size} is the size-------------------------------------------")
        deletedList.forEach{
           if( it){
               list.add(connections[ind])
           }
            ind++
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
    fun search(searchText: String?):List<ConnectionInformation>{
        println("$deletedList")
        _searchResults.value = setValues().toMutableList()
        println("I am inside method search")
//        if(!accessedOnce) {
//            _searchResults.value = setValues().toMutableList()
//            accessedOnce = true
//        }
       println("Inside search")
        val results = mutableListOf<ConnectionInformation>()
        println("${deletedList.size}")
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