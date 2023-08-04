package com.example.hirein.data.DB

import com.example.hirein.data.entity.JobPostDao
import com.example.hirein.data.entity.TagsDao

class JobPostRepository(val jobPostDao: JobPostDao, val tagsDao: TagsDao ) {
}