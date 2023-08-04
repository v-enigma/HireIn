package com.example.hirein.data.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hirein.data.DB.entity.*

@Database( entities = [Company::class,Address::class, EducationalQualification::class,
    AppliedJobs::class, JobPost::class, Skills::class, ProfessionalExperience::class, Tag::class, Field:: class,
    JobRequirement::class,User::class ], version = 1)
abstract class JobPortalDatabase : RoomDatabase() {

     abstract val
    //write abstract functions to  call dao

        @Volatile
        private lateinit var INSTANCE: JobPortalDatabase

        fun getDatabase(context: Context): JobPortalDatabase {
            if (!::INSTANCE.isInitialized) {

              synchronized(this)
              {
                  INSTANCE =  Room.databaseBuilder(context.applicationContext, JobPortalDatabase::class.java, "job_portal").build()
              }

            }
            return INSTANCE!!
        }



}