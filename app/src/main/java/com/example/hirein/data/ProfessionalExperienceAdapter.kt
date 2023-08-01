package com.example.hirein.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.data.model.ProfessionalExperienceData
import com.example.hirein.databinding.ProfessionalExperienceBinding

class ProfessionalExperienceAdapter :ListAdapter<ProfessionalExperienceData,ProfessionalExperienceAdapter.ProfessionalExperienceViewHolder>(ProfessionalExperienceDiffItemCallback()){
    class ProfessionalExperienceViewHolder(val binding:ProfessionalExperienceBinding ): RecyclerView.ViewHolder(binding.root){
       companion object{
           fun inflateFrom(parent: ViewGroup):ProfessionalExperienceViewHolder{
               val layoutInflater = LayoutInflater.from(parent.context)
               val binding = ProfessionalExperienceBinding.inflate(layoutInflater, parent, false)
               return ProfessionalExperienceViewHolder(binding)
           }
       }
       fun bind(item:ProfessionalExperienceData) {
           binding.professionalExperience = item
       }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfessionalExperienceViewHolder {
       return  ProfessionalExperienceViewHolder.inflateFrom(parent)
    }

    override fun onBindViewHolder(holder: ProfessionalExperienceViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}