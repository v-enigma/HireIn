package com.example.hirein.data.db

import android.content.Context
import androidx.lifecycle.lifecycleScope
import androidx.room.*
import com.example.hirein.Convertors
import com.example.hirein.data.db.entity.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Database( entities = [Company::class,Address::class, EducationalQualification::class,
     JobPost::class, Skills::class, ProfessionalExperience::class, Tag::class, Field:: class,
    JobRequirement::class,User::class, Follower::class, AppliedJobs::class ], version = 1, exportSchema = false)
@TypeConverters(Convertors::class)
abstract class JobPortalDatabase : RoomDatabase() {
        abstract fun addressDao() : AddressDao
        abstract fun appliedJobsDao(): AppliedJobsDao
        abstract fun companyDao():CompanyDao
        abstract fun requirementDao(): RequirementDao
        abstract fun tagsDao():TagsDao
        abstract fun skillsDao() : SkillsDao
        abstract fun educationQualificationDao(): EducationalQualificationDao
        abstract fun userDao(): UserDao
        abstract fun registerDao() : RegisterDao
        abstract fun jobPostDao() : JobPostDao

        abstract fun professionalExperienceDao() :ProfessionalExperienceDao

        abstract fun followersDao(): FollowersDao

        companion object {


        @Volatile
        private  var INSTANCE: JobPortalDatabase? = null

        fun getInstance(context: Context):JobPortalDatabase =
            INSTANCE?:synchronized(this){
                println("Creating the database")
                INSTANCE?: buildDatabase(context).also{ INSTANCE = it}
            }
        private fun buildDatabase(context: Context):JobPortalDatabase {
            val instance = Room.databaseBuilder(context.applicationContext, JobPortalDatabase::class.java, "job_portal").build()
            return instance
        }
    }
}