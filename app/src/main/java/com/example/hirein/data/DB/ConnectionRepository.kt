package com.example.hirein.data.db

import androidx.lifecycle.asFlow
import com.example.hirein.Factories.followerFactory
import com.example.hirein.data.ConnectionInformation
import com.example.hirein.data.model.SearchResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class ConnectionRepository(
    private val professionalExperienceDao: ProfessionalExperienceDao,
    private val followersDao :FollowersDao,
    private val userDao:UserDao,

) {

   lateinit var follwersMap: HashMap<Long, Boolean>
    suspend fun getConnections(userId:Long): MutableList<ConnectionInformation>{
        val mutableConnections = mutableListOf<ConnectionInformation>()
        val connectionDetails = followersDao.getConnectionsWithDetails(userId).asFlow().first()

        connectionDetails.forEach{

            val roleAndCompany = professionalExperienceDao.getLatestProfessionalExperience(it.userId).asFlow().first()
            println(roleAndCompany)
            val companyName = roleAndCompany?.companyName?: ""
            val role = roleAndCompany?.role ?: ""
            val profilePhoto = it.profilePhoto ?: ""
            mutableConnections.add(ConnectionInformation(it.userId,it.firstName,it.lastName,companyName,profilePhoto,role))
        }

        return mutableConnections
    }

    suspend fun deleteConnection(userId:Long, followerId:Long){
        withContext(Dispatchers.IO){
            followersDao.removeConnections(followerId, userId)
        }

    }
    suspend fun search(userId: Long, searchQuery: String): List<SearchResults> {

        follwersMap = hashMapOf()
        val users = userDao.searchUserByName(searchQuery).asFlow().first()

        val followersResult = mutableListOf<ConnectionInformation>()
        val othersResult = mutableListOf<ConnectionInformation>()
        users.forEach {
            val userProfessionalDetails =
                professionalExperienceDao.getLatestProfessionalExperience(it.userId).asFlow()
                    .first()
            val isFollower = followersDao.isFollower(userId, it.userId) ?: false
            follwersMap[it.userId] = when (isFollower) {
                false -> {
                    othersResult.add(
                        ConnectionInformation(
                            it.userId,
                            it.firstName,
                            it.lastName,
                            userProfessionalDetails?.companyName ?: " ",
                            it.profilePhoto,
                            userProfessionalDetails?.role ?: " "
                        )
                    );false
                }
                else -> {
                    followersResult.add(
                      ConnectionInformation(
                            it.userId,
                            it.firstName,
                            it.lastName,
                            userProfessionalDetails?.companyName ?:" ",
                            it.profilePhoto,
                            userProfessionalDetails?.role ?: " "
                        )
                    );true
                }
            }

        }
        println("_____________________-NNNN_________________________")
        println(followersResult)
        println("_______--")
        println(othersResult)
        println("_____________________-NNNN_________________________")
        return listOf( SearchResults("Followers",followersResult),SearchResults("Other Users", othersResult))
    }

    suspend fun addConnection(userId: Long, followerId: Long){
        followersDao.addConnection(followerFactory(userId,followerId))
    }

}