package com.example.hirein.data.db

class ConnectionRepository(
  val professionalExperienceDao: ProfessionalExperienceDao,
  val followersDao :FollowersDao
) {
    fun getConnections(userId:Long){
        val connectionDetails = followersDao.getConnectionsWithDetails(userId)


    }
}