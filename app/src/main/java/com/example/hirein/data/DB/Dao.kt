package com.example.hirein.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hirein.data.db.entity.*
import com.example.hirein.data.model.PostOwnerDetails
import java.util.*

@Dao
interface CompanyDao {
    @Insert
    fun insertCompany(company: Company)

    @Update
    fun updateCompany(company: Company)

    @Query("SELECT * FROM company")
    suspend fun getAllCompanies(): List<Company>

    @Query("SELECT * FROM company WHERE companyId = :companyId")
    suspend fun getCompanyById(companyId: Long): Company

}
@Dao
interface RegisterDao{
    @Insert
    fun insertUser(user:User)

    @Query("SELECT user.userId FROM user WHERE (user.mobileNo = :phoneOrEmail AND user.password = :password ) || (user.emailId = :phoneOrEmail AND user.password = :password)")
    suspend fun authenticateUser(phoneOrEmail: String, password:String): Long?
    @Query("SELECT COUNT(*) FROM  user WHERE user.mobileNo = :phone")
    suspend fun isPhoneNumberExist(phone:String):Int
    @Query("SELECT COUNT(*) FROM user WHERE user.emailId =:email")
    suspend fun isEmailIdExist(email:String):Int
    @Query("SELECT COUNT(*) FROM User ")
    suspend fun countRecords():Int
    @Query("SELECT user.userId FROM user WHERE (user.mobileNo = :phoneOrEmail) || (user.emailId = :phoneOrEmail)")
    suspend fun getUserId(phoneOrEmail: String):Long
}
@Dao
interface UserDao {
    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user ")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE userId = :userId")
    suspend fun getUserById(userId: Long): User

    @Query("SELECT user.userId, professionalExperience.role , user.firstName ,user.lastName,user.profilePhoto " +
            "FROM user" +
            " INNER JOIN professionalExperience ON user.userId = :userId " +
            "where (currentlyWorking = true AND  professionalExperience.startDate <= :postedDate  )" +
            " OR " +
            "(professionalExperience.startDate <= :postedDate AND professionalExperience.endDate>=:postedDate) ")
    suspend fun getPostOwner(userId:Long, postedDate: Long ): PostOwnerDetails
}

@Dao
interface FollowersDao{

    @Query(" SELECT user.userId, user.firstName, user.lastName, user.profilePhoto FROM user INNER JOIN "+
            "( SELECT followerId  FROM follower WHERE userId =:userId) as userFollowers  on userFollowers.followerId = user.userId ")
    fun getConnectionsWithDetails(userId: Long) :LiveData<List<ConnectionDetails>>
    @Query("SELECT followerId FROM follower WHERE (follower.userId =:userId)")
     fun getConnections(userId: Long):LiveData<List<Long>>

    @Query("DELETE FROM follower where follower.followerId = :followerId AND Follower.userId = :userId ")
    suspend fun removeConnections(followerId:Long, userId: Long)
    @Insert
    suspend fun addConnection(follower: Follower)
}

@Dao
interface ProfessionalExperienceDao{

    @Query("SELECT name, role FROM company INNER JOIN ( SELECT companyId, role FROM professionalExperience WHERE userId = :userId ORDER BY startDate DESC LIMIT 1 ) as pDetails on company.companyId = pDetails.companyId")
    fun getLatestProfessionalExperience(userId:Long):LiveData<ConnectionProfessionalDetails>
}
@Dao
interface EducationalQualificationDao {
    @Insert
    suspend fun insertProfessionalQualification(professionalExperience: ProfessionalExperience)
    @Insert
    suspend fun insertEducationalQualification(qualification: EducationalQualification)

    @Update
    suspend fun updateEducationalQualification(qualification: EducationalQualification)

    @Query("SELECT * FROM educationalQualification WHERE userId = :userId")
    fun getEducationalQualificationsForUser(userId: Long): LiveData<List<EducationalQualification>>
}
@Dao
interface JobPostDao {
    @Insert
    suspend fun insertJobPost(jobPost: JobPost)

    @Update
    suspend fun updateJobPost(jobPost: JobPost)

    @Delete
    suspend fun deleteJobPost(jobPost: JobPost)

    @Query("SELECT * FROM JobPost WHERE jobPost.postOwnerId =:postOwnerId")
       fun getJobPostFeed(postOwnerId:Long): LiveData<List<JobPost>>
}
@Dao
interface RequirementDao{
    @Insert
    suspend fun insertRequirement(jobRequirement: JobRequirement)

    @Query("SELECT requirement FROM jobRequirement WHERE JobRequirement.jobPostId = :jobPostId")
     suspend fun getRequirement(jobPostId: Long): List<String>

}
@Dao
interface TagsDao{
    @Query("SELECT tag FROM tag WHERE Tag.jobPostId = :postId" )
    suspend fun getTagsOfAJobPost(postId:Long): List<String>
}
@Dao
interface SkillsDao{
    @Insert
    suspend fun insertSkills(skills: Skills)
    @Query("SELECT name FROM skills WHERE Skills.jobPostId =:jobPostId ")
    suspend fun getSkills(jobPostId:Long): List<String>
}

@Dao
interface AddressDao {
    @Insert
    suspend fun insertAddress(address: Address)

    @Update
    suspend fun updateAddress(address: Address)

    @Delete
    suspend fun deleteAddress(address: Address)
    @Query("SELECT companyId FROM company where company.name LIKE '%'||:companyName || '%'")
    fun getCompanyId(companyName:String):LiveData<List<Long>>

    @Query("SELECT * FROM address WHERE companyId = :companyId")
    suspend fun getAddressesForCompany(companyId:Long): List<Address>
}
@Dao
interface AppliedJobsDao{
    @Query("SELECT jobPostId FROM appliedJobs WHERE userId = :userId  ")
     fun getAppliedJobs(userId: Long): LiveData<List<Long>>

    @Query("SELECT  userId FROM  appliedJobs WHERE userId = :userId AND jobPostId = :jobPostId ")
    suspend fun isApplied(userId: Long, jobPostId :Long): Long?

    @Insert
    suspend fun applyToJob(appliedJobs: AppliedJobs)


}

