package com.example.hirein.UI

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hirein.Factories.AdapterFactory
import com.example.hirein.R
import com.example.hirein.data.JobPostViewModel
import com.example.hirein.data.entity.JobPostAdapter
import com.example.hirein.databinding.FragmentJobsBinding

class JobsFragment: Fragment() {
    private  var _binding: FragmentJobsBinding?= null
    private val binding get() =_binding!!
    private lateinit var  viewModel: JobPostViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJobsBinding.inflate(layoutInflater,container,false)
        val view = binding.root
      // checking the received arguments
        println(arguments?.getLong("userId") )
        viewModel = ViewModelProvider(this).get(JobPostViewModel::class.java)
        println("I am create Method call in Home Fragment")
        hideUpButton()
        binding.jobPosts.adapter = JobPostAdapter(this, viewModel.getData())
        //binding.topAppBar.inflateMenu(R.menu.search_menu)

        return view
    }
    override fun onDestroy() {
        _binding = null
        println("Method call to Destroy in HOme Fragment")
        super.onDestroy()
    }

    override fun onStart() {
        super.onStart()

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
    private fun hideUpButton(){
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

}