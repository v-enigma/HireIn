package com.example.hirein.UI

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hirein.data.ConnectionViewModelFactory
import com.example.hirein.data.ConnectionsViewModel
import com.example.hirein.data.SearchResultsAdapter
import com.example.hirein.data.db.ConnectionRepository
import com.example.hirein.data.db.JobPortalDatabase
import com.example.hirein.data.model.SearchResults
import com.example.hirein.databinding.FragmentSearchBinding

class SearchFragment:Fragment() {
    private lateinit var  binding : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View{
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        val database = JobPortalDatabase.getInstance(requireContext())
        val repository = ConnectionRepository(database.professionalExperienceDao(), database.followersDao(),database.userDao())
        val sharedPreferences = requireActivity().getSharedPreferences(CustomSharedPreferences.NAME, Context.MODE_PRIVATE)
        val userId =  sharedPreferences.getLong(CustomSharedPreferences.LOGGED_IN_USER_ID, -1)
        val adapter = SearchResultsAdapter()
        binding.results.adapter = adapter
        val viewModel = ViewModelProvider(requireActivity(),
            ConnectionViewModelFactory(repository, userId)
        )[ConnectionsViewModel::class.java]
        viewModel.searchResults.observe(this){

            binding.progressBar.visibility = GONE
            binding.results.visibility = VISIBLE
            adapter.submitList(it)


        }


        return binding.root
    }



}