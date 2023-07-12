package com.example.hirein.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hirein.Factories.AdapterFactory
import com.example.hirein.data.entity.JobPostAdapter
import com.example.hirein.databinding.FragmentJobsBinding

class JobsFragment: Fragment() {
    private  var _binding: FragmentJobsBinding?= null
    private val binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJobsBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        println("I am recreated home")
        val adapter =  JobPostAdapter()
        binding.jobPosts.adapter = adapter
        return view
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        println("Jobs Fragment on focus")
    }

}