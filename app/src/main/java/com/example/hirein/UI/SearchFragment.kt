package com.example.hirein.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hirein.R
import com.example.hirein.data.ConnectionsViewModel
import com.example.hirein.data.SearchResultsAdapter
import com.example.hirein.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

   private var _binding : FragmentSearchBinding?= null
    private val binding get() = _binding!!
    private lateinit var viewmodel: ConnectionsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(requireActivity())[ConnectionsViewModel::class.java]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        println("Inside the Search Fragment")
        _binding = FragmentSearchBinding.inflate(layoutInflater,container,false)
        val adapter = SearchResultsAdapter()
        binding.rvSearchResults.adapter = adapter
        viewmodel.searchResults.observe(viewLifecycleOwner){
            it?.let{adapter.submitList(it)}
        }
        return binding.root
    }

}