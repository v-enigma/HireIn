package com.example.hirein.data

import androidx.recyclerview.widget.DiffUtil
import com.example.hirein.data.model.*

class ConnectionsDiffItemCallback: DiffUtil.ItemCallback<ConnectionInformation>() {
    override fun areItemsTheSame(
        oldItem: ConnectionInformation,
        newItem: ConnectionInformation
    ): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: ConnectionInformation,
        newItem: ConnectionInformation
    ): Boolean  = oldItem == newItem
}

class JobFeedDiffItemCallBack: DiffUtil.ItemCallback<JobPostData>(){
    override fun areItemsTheSame(oldItem: JobPostData, newItem: JobPostData) = oldItem == newItem

    override fun areContentsTheSame(oldItem: JobPostData, newItem: JobPostData) = oldItem == newItem


}
class EducationDiffItemCallback: DiffUtil.ItemCallback<EducationData>() {
    override fun areItemsTheSame(oldItem: EducationData, newItem: EducationData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: EducationData, newItem: EducationData): Boolean {
        return (oldItem == newItem)
    }
}
class SearchResultsDiffItemCallBack: DiffUtil.ItemCallback<SearchResults>(){
    override fun areItemsTheSame(oldItem: SearchResults, newItem: SearchResults): Boolean {
       return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SearchResults, newItem: SearchResults): Boolean {
        return oldItem == newItem
    }

}

class SearchLineResultDiffItemCallBack: DiffUtil.ItemCallback<ConnectionInformation>(){
    override fun areItemsTheSame(oldItem: ConnectionInformation, newItem: ConnectionInformation): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ConnectionInformation, newItem: ConnectionInformation): Boolean {
        return oldItem == newItem
    }

}

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