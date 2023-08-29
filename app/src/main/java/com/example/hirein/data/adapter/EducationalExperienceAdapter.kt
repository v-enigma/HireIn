package com.example.hirein.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.data.EducationDiffItemCallback
import com.example.hirein.data.model.EducationData
import com.example.hirein.databinding.EducationQualificationBinding

class EducationalExperienceAdapter:ListAdapter<EducationData, EducationalExperienceAdapter.EducationalExperienceViewHolder>(
    EducationDiffItemCallback()
) {
    class EducationalExperienceViewHolder(val binding:EducationQualificationBinding):RecyclerView.ViewHolder(binding.root){
        companion object {
            fun inflateFrom(parent: ViewGroup): EducationalExperienceViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = EducationQualificationBinding.inflate(layoutInflater,parent,false)
                return EducationalExperienceViewHolder(binding)
            }
        }
        fun bind(item: EducationData){
            binding.educationData = item
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EducationalExperienceViewHolder {
        return EducationalExperienceViewHolder.inflateFrom(parent)
    }

    override fun onBindViewHolder(holder: EducationalExperienceViewHolder, position: Int) {
       val item = getItem(position)
       holder.bind(item)
    }

}