package com.example.hirein.UI
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hirein.R
import com.example.hirein.data.JobPostViewModelFactory
import com.example.hirein.data.JobPostsViewModel
import com.example.hirein.data.SharedJobPostData
import com.example.hirein.data.SharedJobPostViewModelFactory
import com.example.hirein.data.db.JobPortalDatabase
import com.example.hirein.data.db.JobPostRepository
import com.example.hirein.databinding.PostDetailBinding



class PostDetailFragment: Fragment() {
    private var _binding: PostDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var application : JobPortalDatabase
    private lateinit var sharedViewModel : JobPostsViewModel
    private lateinit var sharedPreferences: SharedPreferences
    val args : PostDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //setupBackButton()

        _binding = PostDetailBinding.inflate(layoutInflater, container,false)
        application = JobPortalDatabase.getInstance(requireContext())
        sharedPreferences = requireActivity().getSharedPreferences(CustomSharedPreferences.NAME, Context.MODE_PRIVATE)
        val repository = JobPostRepository(application.jobPostDao(),application.tagsDao(),application.userDao(), application.companyDao(), application.skillsDao(),application.requirementDao(), application.appliedJobsDao(),application.followersDao())
        val userId =  sharedPreferences.getLong(CustomSharedPreferences.LOGGED_IN_USER_ID, -1)
        sharedViewModel = ViewModelProvider(requireActivity(),JobPostViewModelFactory(repository,userId))[JobPostsViewModel::class.java]
        //println("${sharedViewModel.jobPostData}")

       //val navHostFragment = NavHostFragment.findNavController(this)
        // showing the back button in action bar
        val view = binding.root
        val index = args.index
        if(index >= 0) {
            binding.jobPostData = sharedViewModel.jobsFeed[index]
            val directions = PostDetailFragmentDirections.actionPostDetailFragmentToProfileFragment(
                sharedViewModel.jobsFeed[index].postOwnerDetails.userId
            )
            binding.arrowIcon.setOnClickListener {
                println(" Clicked ")
                findNavController().navigate(directions)
            }
        }
        binding.btnApply.setOnClickListener{
             it.isEnabled = false
             binding.btnApply.text = "APPLIED"
             binding.btnApply.setBackgroundColor(resources.getColor(R.color.grey))
            sharedViewModel.applyToJob(userId, sharedViewModel.jobsFeed[index].postId,index )
        }
        /*//binding.topAppBar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        //binding.topAppBar.setNavigationOnClickListener{
            requireActivity().onNavigateUp()
        }*/
        return view
    }
//    private fun setupBackButton() {
//        if (activity is AppCompatActivity) {
//            (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        }
//    }

   /* override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        // handle the up button here
        println("I came inside the Setup")
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
*/


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        //requireActivity().title = "HireIn"
        println("Post Detail Fragment on focus")
    }
}