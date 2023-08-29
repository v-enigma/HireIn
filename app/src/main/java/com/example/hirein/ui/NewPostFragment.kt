package com.example.hirein.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.hirein.R

class NewPostFragment: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        println("I am recreated post")
        setMenuVisibility(false)
        //(requireActivity() as MainActivity).setupActionBar(binding.topAppBar)
        return inflater.inflate(R.layout.fragment_post,container,false)
    }

    override fun onResume() {
        requireActivity().title = "HireIn"
        super.onResume()
    }

}