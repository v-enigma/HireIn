package com.example.hirein.UI
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hirein.data.SharedJobPostData
import com.example.hirein.databinding.PostDetailBinding



class PostDetailFragment: Fragment() {
    private var _binding: PostDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var sharedViewModel : SharedJobPostData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //setupBackButton()
        _binding = PostDetailBinding.inflate(layoutInflater, container,false)
        sharedViewModel = ViewModelProvider(requireActivity())[SharedJobPostData::class.java]
        println("${sharedViewModel.jobPostData}")

       //val navHostFragment = NavHostFragment.findNavController(this)
        // showing the back button in action bar
        val view = binding.root
        binding.jobPostData = sharedViewModel.jobPostData
        val directions = PostDetailFragmentDirections.actionPostDetailFragmentToProfileFragment(sharedViewModel.jobPostData.postOwnerDetails.postOwnerId)
        binding.arrowIcon.setOnClickListener{
            println(" Clicked ")
           findNavController().navigate(directions)
        }

        /*//binding.topAppBar.setNavigationIcon(R.drawable.baseline_arrow_back_24)
        //binding.topAppBar.setNavigationOnClickListener{
            requireActivity().onNavigateUp()
        }*/
        return view
    }
//    private fun setupBackButton() {
//        if (activity is AppCompatActivity) {
//            (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        }
//    }

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
        //requireActivity().title = "HireIn"
        println("Post Detail Fragment on focus")
    }
}