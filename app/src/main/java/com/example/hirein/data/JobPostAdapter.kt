package com.example.hirein.data.entity

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.R
import com.example.hirein.UI.PostDetailFragment
import de.hdodenhof.circleimageview.CircleImageView
import java.time.LocalDate

class JobPostAdapter: RecyclerView.Adapter<JobPostAdapter.JobPostViewHolder>() {
    @RequiresApi(Build.VERSION_CODES.O)
    var jobPosts : List<JobPost> = listOf(
           JobPost(1,"Android Developer","Engineering/IT",0,2,"FullTime", 600000,1000000,1, "Hybrid","Chennai",
              System.currentTimeMillis(),"Open")
    )
     class JobPostViewHolder(item :View ):RecyclerView.ViewHolder(item){
         var roleName : TextView = item.findViewById(R.id.roleName)
         var salaryRange:TextView = item.findViewById(R.id.salaryRange)
         var instituteName:TextView = item.findViewById(R.id.instituteName)
         var employmentCount :TextView = item.findViewById(R.id.employeeCount)
         var jobType :TextView = item.findViewById(R.id.jobType)
         var image: CircleImageView = item.findViewById(R.id.postOwnerImage)
         var postOwnerName : TextView = item.findViewById(R.id.postOwnerName)
         var recruiterRole :TextView = item.findViewById(R.id.recruiterRole)
         var jobLocation :TextView = item.findViewById(R.id.jobLocation)
         var jobRequirement :TextView = item.findViewById(R.id.jobRequirements)
         init{
             item.setOnClickListener{

             }
         }
         companion object{
             fun inflate(parent: ViewGroup): JobPostViewHolder{
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val view = layoutInflater.inflate(R.layout.post_view2,parent, false) as View
                 return JobPostViewHolder(view)
             }
         }
         fun bind(item :JobPost){
             //have to do
             //this.salaryRange = item
             var salaryRange :String ="Rs"
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPostViewHolder = JobPostViewHolder.inflate(parent)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getItemCount(): Int {
        return jobPosts.size
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: JobPostViewHolder, position: Int) {
       val item = jobPosts[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            val  activity = it.context as AppCompatActivity
            val direction =

            val postDetailFragment = PostDetailFragment()
            activity.supportFragmentManager.beginTransaction().replace(R.id.postFeed, postDetailFragment).addToBackStack("Detailed View of the Post").commit()
        }
    }
}