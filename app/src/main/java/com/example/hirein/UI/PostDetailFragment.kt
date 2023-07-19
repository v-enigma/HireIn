package com.example.hirein.UI
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.hirein.R
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
        //setupBackButton()
        _binding = PostDetailBinding.inflate(layoutInflater, container,false)

       //val navHostFragment = NavHostFragment.findNavController(this)
        // showing the back button in action bar
        val view = binding.root
        binding.topAppBar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        binding.topAppBar.setNavigationOnClickListener{
            requireActivity().onNavigateUp()
        }
        return view
    }
//    private fun setupBackButton() {
//        if (activity is AppCompatActivity) {
//            (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        }
//    }
    @Deprecated("Deprecated in Java")
   /* override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        // handle the up button here
        println("I came inside the Setup")
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
*/


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        activity!!.title = "HireIn"
        println("Post Detail Fragment on focus")
    }
}