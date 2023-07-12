package com.example.hirein.data.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database( entities = [Company::class], version = 1)
abstract class JobPortalDatabase : RoomDatabase() {


    //write abstract functions to  call dao
    companion object {
        @Volatile
        private var INSTANCE: JobPortalDatabase? = null

        fun getDatabase(context: Context): JobPortalDatabase {
            if (INSTANCE == null) {

              synchronized(this)
              {
                  INSTANCE =  Room.databaseBuilder(context.applicationContext, JobPortalDatabase::class.java, "job_portal").build()
              }

            }
            return INSTANCE!!
        }

    }

}