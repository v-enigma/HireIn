package com.example.hirein.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hirein.data.EducationalExperienceAdapter
import com.example.hirein.data.ProfessionalExperienceAdapter
import com.example.hirein.databinding.FragmentUserDetailsBinding

class UserDetailsFragment: Fragment() {
    private  var _binding: FragmentUserDetailsBinding? = null
    private val  binding get() = _binding!!
    //private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserDetailsBinding.inflate(layoutInflater,container, false)
        binding.rvProfessionalExp.adapter = ProfessionalExperienceAdapter()
        binding.rvEducationalExperiences.adapter = EducationalExperienceAdapter()
        //binding.rvJobPosts.adapter = JobPostAdapter()
        return binding.root
    }
}