package com.example.hirein.data.entity

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.R
import com.example.hirein.UI.JobsFragmentDirections
import com.example.hirein.data.model.JobPostData
import de.hdodenhof.circleimageview.CircleImageView

class JobPostAdapter(val fragment: Fragment, post : LiveData<List<JobPostData>>,val callback: ( jobPostData:JobPostData)-> Unit): RecyclerView.Adapter<JobPostAdapter.JobPostViewHolder>() {

    var jobPostsData = post.value


    class JobPostViewHolder(item :View ):RecyclerView.ViewHolder(item){
         var roleName : TextView = item.findViewById(R.id.roleName)
         var salaryRange:TextView = item.findViewById(R.id.salaryRange)
         var instituteName:TextView = item.findViewById(R.id.instituteName)
         //var employmentCount :TextView = item.findViewById(R.id.employeeCount)
         var jobType :TextView = item.findViewById(R.id.workingModel)
         var image: CircleImageView = item.findViewById(R.id.postOwnerImage)
         //var postOwnerName : TextView = item.findViewById(R.id.postOwnerName)
         //var recruiterRole :TextView = item.findViewById(R.id.recruiterRole)
         var jobLocation :TextView = item.findViewById(R.id.jobLocation)
         var jobRequirement :TextView = item.findViewById(R.id.jobRequirements)

         companion object{
             fun inflate(parent: ViewGroup): JobPostViewHolder{
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val view = layoutInflater.inflate(R.layout.post_view,parent, false) as View
                 return JobPostViewHolder(view)
             }
         }
         fun bind(item :JobPostData){
             //have to do
             //this.salaryRange = item
             var salaryRange :String ="Rs "
             if(item.minSalary >= 100000){
                 val minSal = item.minSalary/100000
                 salaryRange+= "$minSal -"
                 val maxSalary = item.maxSalary/100000
                 salaryRange+= "${maxSalary}LPA"

             }else{
                 salaryRange = "Rs ${item.minSalary} - ${item.maxSalary}"
             }
             this.salaryRange.text = salaryRange
             this.roleName.text = item.jobTitle
             this.jobLocation.text = item.workLocation
             this.jobType.text = item.locationType
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPostViewHolder {
        val viewHolder = JobPostViewHolder.inflate(parent)

        return viewHolder
    }

    override fun getItemCount(): Int {
        return jobPostsData?.size ?: 0
    }

    override fun onBindViewHolder(holder: JobPostViewHolder, position: Int) {
        val item = jobPostsData?.get(position)
        item?.let{holder.bind(it)}
        holder.itemView.setOnClickListener {
           item?.let{
               callback(item)
               val direction = JobsFragmentDirections.actionHomeFragmentToPostDetailFragment()
               findNavController(fragment).navigate(direction)
           }

        }
    }
}