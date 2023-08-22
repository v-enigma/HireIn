package com.example.hirein.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.hirein.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment: BottomSheetDialogFragment() {
   private  var index = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args : Bundle? = savedInstanceState ?: arguments

        index = args?.getInt("Index")?: -1
        println("$index i accessed the Index")

        val view = inflater.inflate(R.layout.bottom_sheet_layout, container,false)


        view.findViewById<LinearLayout>(R.id.unfollow).setOnClickListener {
            println("Clicked")
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