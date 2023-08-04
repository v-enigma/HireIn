package com.example.hirein.UI

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.hirein.R
import com.example.hirein.data.JobPostViewModel
import com.example.hirein.data.SharedJobPostData
import com.example.hirein.data.UserIdViewModel
import com.example.hirein.data.entity.JobPostAdapter
import com.example.hirein.databinding.FragmentJobsBinding

class JobsFragment: Fragment() {
    private  var _binding: FragmentJobsBinding?= null
    private val binding get() =_binding!!
    private lateinit var  viewModel: JobPostViewModel
    private lateinit var sharedViewModel: SharedJobPostData
    private lateinit var userIdViewModel: UserIdViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJobsBinding.inflate(layoutInflater,container,false)
        val view = binding.root
      // checking the received arguments

        userIdViewModel = ViewModelProvider(requireActivity())[UserIdViewModel::class.java]
        println("viewModel intialized")
        viewModel = ViewModelProvider(this)[JobPostViewModel::class.java]
       // println("I am create Method call in Home Fragment")
        //hideUpButton()
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedJobPostData::class.java)
        binding.jobPosts.adapter = JobPostAdapter(this, viewModel.getData()){
            jobPostData -> sharedViewModel.jobPostData = jobPostData
        }

        //binding.topAppBar.inflateMenu(R.menu.search_menu)

        return view
    }
    override fun onDestroy() {
        _binding = null
        println("Method call to Destroy in Home Fragment")
        super.onDestroy()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        println("I am inside opions created")
        inflater.inflate(R.menu.search_menu,menu)
    }
    override fun onResume() {
        super.onResume()
       requireActivity().title = "HireIn"
        println("Jobs Fragment on focus")
    }
//    private fun hideUpButton(){
//        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
//    }

}