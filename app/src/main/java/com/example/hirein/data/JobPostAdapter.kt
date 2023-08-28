package com.example.hirein.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.UI.JobsFragmentDirections
import com.example.hirein.data.JobFeedDiffItemCallBack
import com.example.hirein.data.model.JobPostData
import com.example.hirein.databinding.PostViewBinding

class JobPostAdapter(val fragment: Fragment): ListAdapter<JobPostData,JobPostAdapter.JobPostViewHolder>(
    JobFeedDiffItemCallBack()
) {

    private lateinit var binding: PostViewBinding
    class JobPostViewHolder(
        private val binding :PostViewBinding ):RecyclerView.ViewHolder(binding.root){
         fun bind(item :JobPostData){
            binding.jobPostData = item
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPostViewHolder {
        binding = PostViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return JobPostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobPostViewHolder, position: Int) {
        val item = getItem(position)
        item.let{holder.bind(it)}
        holder.itemView.setOnClickListener {
            item.let{
                //callback(item)
                println(" kapt $position")
                val direction = JobsFragmentDirections.actionHomeFragmentToPostDetailFragment(position)
                findNavController(fragment).navigate(direction)
            }
        }
    }

}