package com.example.hirein.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hirein.data.entity.JobPostAdapter
import com.example.hirein.databinding.PostDetailBinding


class PostDetailFragment: Fragment() {
    private var _binding: PostDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PostDetailBinding.inflate(layoutInflater, container,false)
        val view = binding.root
        return view

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        println("Post Detail Fragment on focus")
    }
}