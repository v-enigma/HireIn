package com.example.hirein.data

import androidx.recyclerview.widget.DiffUtil
import com.example.hirein.data.model.ProfessionalExperienceData

class ProfessionalExperienceDiffItemCallback: DiffUtil.ItemCallback<ProfessionalExperienceData>(){
    override fun areItemsTheSame(
        oldItem: ProfessionalExperienceData,
        newItem: ProfessionalExperienceData
    ): Boolean {
       return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: ProfessionalExperienceData,
        newItem: ProfessionalExperienceData
    ): Boolean {
        return oldItem == newItem
    }
}