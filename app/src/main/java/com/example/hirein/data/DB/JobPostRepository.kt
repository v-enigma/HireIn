package com.example.hirein.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.example.hirein.data.db.entity.AppliedJobs
import com.example.hirein.data.db.entity.Company
import com.example.hirein.data.model.JobPostData
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first

class JobPostRepository(
    private val jobPostDao: JobPostDao,
    private val tagsDao: TagsDao,
    private val userDao: UserDao,
    private val companyDao: CompanyDao,
    private val skillsDao: SkillsDao,
    private val requirementDao: RequirementDao,
    private val appliedJobsDao: AppliedJobsDao,
    private val followersDao: FollowersDao
) {

    suspend fun getJobPosts(userId: Long): MutableList<JobPostData> {
        println("Inside the jobPosts")
        val jobsFeed = mutableListOf<JobPostData>()
        var companyReferences: HashMap<Long, Company> = HashMap()
        val appliedJobs = appliedJobsDao.getAppliedJobs(userId).asFlow().first()
        val followers = followersDao.getConnections(userId).asFlow().first()
        followers.forEach { followerId ->
            val jobPosts = jobPostDao.getJobPostFeed(followerId).asFlow().first()

            jobPosts.forEach {
                if (!appliedJobs.contains(it.jobPostId)) {
                    val company: Company =
                        when {
                            (companyReferences.containsKey(it.companyId)) -> companyReferences.getValue(
                                it.companyId
                            )
                            else -> {
                                val temp = companyDao.getCompanyById(it.companyId)
                                companyReferences[temp.companyId] = temp
                                temp
                            }
                        }
                    val tags = tagsDao.getTagsOfAJobPost(it.jobPostId)
                    val requirements = requirementDao.getRequirement(it.jobPostId)
                    val skills = skillsDao.getSkills(it.jobPostId)
                    val postOwnerDetails = userDao.getPostOwner(it.postOwnerId, it.postedDate.time)
                    //println("------------------- $tags $requirements $skills $postOwnerDetails ________________")
                    appliedJobsDao.isApplied(userId, it.jobPostId) ?: run {
                        val jobPost = JobPostData(
                            it.jobPostId,
                            postOwnerDetails,
                            it.jobTitle,
                            it.Industry,
                            it.minExperience,
                            it.maxExperience,
                            it.employmentType,
                            it.minSalary,
                            it.maxSalary,
                            company,
                            tags,
                            it.locationType,
                            it.workLocation,
                            requirements,
                            skills,
                            it.postedDate.time,
                            it.applicationStatus
                        )
                        println(jobPost)
                        jobsFeed.add(jobPost)
                    }
                }
            }
        }
        return jobsFeed
    }
    suspend fun applyToJob(userId: Long, jobPostId:Long){

        appliedJobsDao.applyToJob(AppliedJobs(userId,jobPostId))

    }

}