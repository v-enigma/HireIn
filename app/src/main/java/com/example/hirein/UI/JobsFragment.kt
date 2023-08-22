package com.example.hirein.UI

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.hirein.R
import com.example.hirein.data.*
import com.example.hirein.data.db.JobPortalDatabase
import com.example.hirein.data.db.JobPostRepository
import com.example.hirein.data.entity.JobPostAdapter
import com.example.hirein.data.model.JobPostData
import com.example.hirein.databinding.FragmentJobsBinding

class JobsFragment: Fragment() {
    private  var _binding: FragmentJobsBinding?= null
    private val binding get() =_binding!!
    private lateinit var application :JobPortalDatabase
    private lateinit var  viewModel: JobPostsViewModel
    private lateinit var userIdViewModel: UserIdViewModel
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var localJobsFeed: List<JobPostData>
    private lateinit var adapter: JobPostAdapter
    private var paused= false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobsBinding.inflate(layoutInflater,container,false)
        val view = binding.root
      // checking the received arguments
       sharedPreferences = requireActivity().getSharedPreferences(CustomSharedPreferences.NAME, Context.MODE_PRIVATE)
        userIdViewModel = ViewModelProvider(requireActivity())[UserIdViewModel::class.java]
        println("viewModel intialized")
        application = JobPortalDatabase.getInstance(requireContext())
        val repository = JobPostRepository(application.jobPostDao(),application.tagsDao(),application.userDao(), application.companyDao(), application.skillsDao(),application.requirementDao(), application.appliedJobsDao(),application.followersDao())
        val userId =  sharedPreferences.getLong(CustomSharedPreferences.LOGGED_IN_USER_ID, -1)
        println("UserId $userId")
        if(userId > 0) {
            viewModel = ViewModelProvider(
                requireActivity(),
                JobPostViewModelFactory(repository,userId)
            )[JobPostsViewModel::class.java]
            // println("I am create Method call in Home Fragment")
            //hideUpButton()
            viewModel.initializeJobsFeed {
                localJobsFeed = viewModel.jobsFeed
              requireActivity().runOnUiThread{
                  adapter = JobPostAdapter(this@JobsFragment, viewModel.jobsFeed)
                  binding.jobPosts.adapter = adapter

              }

            }
            //sharedViewModel = ViewModelProvider(requireActivity(),SharedJobPostViewModelFactory(repository,userId)).get(SharedJobPostData::class.java)

        }


        //binding.topAppBar.inflateMenu(R.menu.search_menu)
        return view
    }
    override fun onDestroy() {
        _binding = null

        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        this.paused = true
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        println("I am inside opions created")
        inflater.inflate(R.menu.search_menu,menu)
    }
    override fun onResume() {
        super.onResume()
       requireActivity().title = "HireIn"
       if(paused && viewModel.jobsFeed.size != localJobsFeed.size){
           println("INNNNN")
          adapter.updateData(viewModel.jobsFeed)
       }
    }
//    private fun hideUpButton(){
//        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
//    }

}