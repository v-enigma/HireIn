package com.example.hirein.data

import androidx.recyclerview.widget.DiffUtil
import com.example.hirein.data.model.EducationData

class EducationDiffItemCallback: DiffUtil.ItemCallback<EducationData>() {
    override fun areItemsTheSame(oldItem: EducationData, newItem: EducationData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EducationData, newItem: EducationData): Boolean {
      return (oldItem == newItem)
    }
}