package com.example.hirein.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import com.example.hirein.R
import com.example.hirein.data.ConnectionViewModelFactory
import com.example.hirein.data.viewModel.ConnectionsViewModel
import com.example.hirein.data.db.ConnectionRepository
import com.example.hirein.data.db.JobPortalDatabase
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment: BottomSheetDialogFragment() {
   private  var index = -1
   private lateinit var viewModel : ConnectionsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args : Bundle? = savedInstanceState ?: arguments
        val database = JobPortalDatabase.getInstance(requireContext())
        val repository = ConnectionRepository(database.professionalExperienceDao(), database.followersDao(),database.userDao())
        val sharedPreferences = requireActivity().getSharedPreferences(CustomSharedPreferences.NAME, Context.MODE_PRIVATE)
        val userId =  sharedPreferences.getLong(CustomSharedPreferences.LOGGED_IN_USER_ID, -1)
        viewModel = ViewModelProvider(requireActivity(),ConnectionViewModelFactory(repository, userId)).get(
            ConnectionsViewModel::class.java)
        index = args?.getInt("Index")?: -1
        println("$index i accessed the Index")

        val view = inflater.inflate(R.layout.bottom_sheet_layout, container,false)


        view.findViewById<LinearLayout>(R.id.unfollow).setOnClickListener {
            println("Clicked")
            viewModel.unFollow(viewModel.followers.value!!.get(index).id,index)
            setFragmentResult("Index", bundleOf("Index" to index))
            println("Clicked after")
            //findNavController().popBackStack()
            dismiss()
        }
        return view

    }
    override fun getTheme(): Int {

        println("I am using theme in the fragment")
        return R.style.CustomBottomSheetDialog
    }

    override fun onResume() {
        dialog as BottomSheetDialog
        super.onResume()
    }

    override fun onDestroyView() {
        println("I am called in bottom sheet ")
        super.onDestroyView()
    }



}