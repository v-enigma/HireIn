package com.example.hirein.data.entity

import androidx.room.*

@Dao
interface CompanyDao {
    @Insert
    fun insertCompany(company: Company)

    @Update
    fun updateCompany(company: Company)

    @Query("SELECT * FROM company")
    fun getAllCompanies(): List<Company>

    @Query("SELECT * FROM company WHERE companyId = :companyId")
    fun getCompanyById(companyId: Long): Company


}
@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user WHERE userId = :userId")
    fun getUserById(userId: Long): User
    @Query("SELECT followerId, FROM Follower  where Follower.userId = :userId ")
    fun getConnections(userId: Long) :List<Long>
    @Query("DELETE FROM Follower where Follower.followerId = :followerId AND Follower.userId = userId ")
    fun removeConnections(follwerId:Long, userId: Long)
}
@Dao
interface EducationalQualificationDao {
    @Insert
    fun insertEducationalQualification(qualification: EducationalQualification)

    @Update
    fun updateEducationalQualification(qualification: EducationalQualification)

    @Query("SELECT * FROM educational_qualifications WHERE userId = :userId")
    fun getEducationalQualificationsForUser(userId: Long): List<EducationalQualification>
}
@Dao
interface JobPostDao {
    @Insert
    fun insertJobPost(jobPost: JobPost)

    @Update
    fun updateJobPost(jobPost: JobPost)

    @Delete
    fun deleteJobPost(jobPost: JobPost)

    @Query("SELECT * FROM jobpost WHERE jobPostId = :jobPostId")
    fun getJobPostWithTags(userId: Long): List<JobPost>
}
data class JobPostWithTags(
    @Embedded val jobPost: JobPost,
    @Relation(
        parentColumn = "jobPostId",
        entityColumn = "jobPostId"
    )
    val tags: List<Tag>
)

interface AddressDao {
    @Insert
    fun insertAddress(address: Address)

    @Update
    fun updateAddress(address: Address)

    @Delete
    fun deleteAddress(address: Address)
    @Query("SELECT * FROM Company where company.name LIKE '%'||:companyName || '%'")
    fun getCompanyId(companyName:String):List<Long>

    @Query("SELECT * FROM address WHERE companyId = :companyId")
    fun getAddressesForCompany(): List<Address>

}

