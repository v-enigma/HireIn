package com.example.hirein.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hirein.data.db.ConnectionRepository
import com.example.hirein.data.model.ConnectionInformation
import com.example.hirein.data.model.SearchResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ConnectionsViewModel(private val connectionRepository: ConnectionRepository,
                           private val userId: Long):ViewModel() {
      var searchResults = MutableLiveData<List<SearchResults>>()
    //var searchResults :MutableLiveData<MutableList<ConnectionInformation>> = _searchResults
    //var connections = MutableLiveData<MutableList<ConnectionInformation>>()
    //private val deletedList = mutableListOf<Boolean>()

   private val _followers = MutableLiveData<List<ConnectionInformation>>()
    val followers :LiveData<List<ConnectionInformation>> = _followers
    //val followers : LiveData<MutableList<ConnectionInformation>> get() = _followers

    fun initializeFollowers(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _followers.postValue( connectionRepository.getConnections(userId))
            }
        }

    }
    /* fun deleteFollower(position:Int){
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
     }*/
    fun search(searchText:String){
        if(searchText.isNotEmpty()){
            viewModelScope.launch {
                withContext(Dispatchers.IO){
                    searchResults.postValue(connectionRepository.search(userId,searchText))
                    println(searchResults.value)
                }
            }

        }
    }
    private fun remove(index:Int){
       val currentFollowers = _followers.value.orEmpty()
       val newList = currentFollowers.toMutableList()
       newList.removeAt(index)
       _followers.value = newList

    }
     fun unFollow(followerId:Long,index:Int){
        viewModelScope.launch{
                connectionRepository.deleteConnection(userId,followerId)
                println("$followerId III")
                remove(index)
        }


    }
}