package com.example.hirein.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        bindListener()
        return binding.root
    }
    private fun bindListener(){
        binding.downArrow.setOnClickListener{
            expandList(binding.rvEducationalExperiences,it, binding.upArrow)
        }
        binding.upArrow.setOnClickListener{
            hideList(binding.rvEducationalExperiences, binding.downArrow, it)
        }
        binding.professionDownArrow.setOnClickListener{
            expandList(binding.rvProfessionalExpression, it, binding.professionUpArrow)
        }
        binding.professionUpArrow.setOnClickListener{
            hideList(binding.rvProfessionalExpression, binding.professionDownArrow, it)
        }
    }
    private fun hideList(recyclerView: RecyclerView, downArrow: View, upArrow:View){
        recyclerView.visibility = GONE
        downArrow.visibility = VISIBLE
        upArrow.visibility = GONE
    }

    private fun expandList(recyclerView: RecyclerView,downArrow: View, upArrow: View){
        recyclerView.visibility = VISIBLE
        downArrow.visibility = GONE
        upArrow.visibility = VISIBLE
    }
}