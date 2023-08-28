/*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.hirein.data.db.entity.Company
import com.example.hirein.data.model.JobPostData
import com.example.hirein.data.model.PostOwnerDetails

class JobPostDataRepository(
    userRepository: UserRepository,
    tagRepository: TagRepository,
    companyRepository: CompanyRepository
) {
    private val userRepository: UserRepository
    private val tagRepository: TagRepository
    private val companyRepository: CompanyRepository

    init {
        this.userRepository = userRepository
        this.tagRepository = tagRepository
        this.companyRepository = companyRepository
    }

    fun getCombinedJobPostData(postId: Long): LiveData<JobPostData> {
        val combinedLiveData = MediatorLiveData<JobPostData>()
        val ownerDetailsLiveData: LiveData<PostOwnerDetails> =
            userRepository.getPostOwnerDetails(postId)
        val tagsLiveData: LiveData<List<String>> = tagRepository.getTagsForJobPost(postId)
        val companyLiveData: LiveData<Company> = companyRepository.getCompanyForJobPost(postId)
        combinedLiveData.addSource(ownerDetailsLiveData, object : Observer<PostOwnerDetails?> {
            override fun onChanged(ownerDetails: PostOwnerDetails) {
                val (postId1, _, jobTitle, Industry, minExperience, maxExperience, employmentType, minSalary, maxSalary, company, tags, locationType, workLocation, jobRequirements, jobSkills, postedDate, applicationStatus) = combinedLiveData.value
                    ?: return
                // Update existing JobPostData object with owner details
                val newValue = JobPostData(
                    postId1, ownerDetails,
                    jobTitle, Industry,
                    minExperience, maxExperience,
                    employmentType, minSalary,
                    maxSalary, company,
                    tags, locationType,
                    workLocation, jobRequirements,
                    jobSkills, postedDate,
                    applicationStatus
                )
                combinedLiveData.setValue(newValue)
            }
        })
        combinedLiveData.addSource(tagsLiveData, object : Observer<List<String?>?> {
            override fun onChanged(tags: List<String?>) {
                val (postId1, postOwnerDetails, jobTitle, Industry, minExperience, maxExperience, employmentType, minSalary, maxSalary, company, _, locationType, workLocation, jobRequirements, jobSkills, postedDate, applicationStatus) = combinedLiveData.value
                    ?: return
                // Update existing JobPostData object with tags
                val newValue = JobPostData(
                    postId1, postOwnerDetails,
                    jobTitle, Industry,
                    minExperience, maxExperience,
                    employmentType, minSalary,
                    maxSalary, company,
                    tags, locationType,
                    workLocation, jobRequirements,
                    jobSkills, postedDate,
                    applicationStatus
                )
                combinedLiveData.setValue(newValue)
            }
        })
        combinedLiveData.addSource(companyLiveData, object : Observer<Company?> {
            override fun onChanged(company: Company) {
                val (postId1, postOwnerDetails, jobTitle, Industry, minExperience, maxExperience, employmentType, minSalary, maxSalary, _, tags, locationType, workLocation, jobRequirements, jobSkills, postedDate, applicationStatus) = combinedLiveData.value
                    ?: return
                // Update existing JobPostData object with company
                val newValue = JobPostData(
                    postId1, postOwnerDetails,
                    jobTitle, Industry,
                    minExperience, maxExperience,
                    employmentType, minSalary,
                    maxSalary, company,
                    tags, locationType,
                    workLocation, jobRequirements,
                    jobSkills, postedDate,
                    applicationStatus
                )
                combinedLiveData.setValue(newValue)
            }
        })
        return combinedLiveData
    }
}*/
