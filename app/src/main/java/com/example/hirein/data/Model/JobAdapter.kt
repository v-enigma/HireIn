package com.example.hirein.data.Model

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class JobPostAdapter : RecyclerView.Adapter<JobPostAdapter.JobPostViewHolder>() {
    var jobPosts : List<JobPost> = listOf()
     class JobPostViewHolder(val rootView: LinearLayout ):RecyclerView.ViewHolder(rootView){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPostViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return jobPosts.size
    }

    override fun onBindViewHolder(holder: JobPostViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}