package com.example.hirein.UI

import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hirein.R
import com.example.hirein.data.ConnectionViewModelFactory
import com.example.hirein.data.ConnectionsViewModel
import com.example.hirein.data.db.ConnectionRepository
import com.example.hirein.data.db.JobPortalDatabase
import com.example.hirein.data.entity.ConnectionsAdapter
import com.example.hirein.databinding.FragmentConnectionsBinding


class ConnectionsFragment:Fragment() {
    private  var _binding: FragmentConnectionsBinding? = null
    private val binding get() =_binding!!
    private lateinit var viewModel: ConnectionsViewModel
    private lateinit var menuProvider:MenuProvider
    private lateinit var database: JobPortalDatabase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConnectionsBinding.inflate(inflater,container,false)
        database = JobPortalDatabase.getInstance(requireContext())
        val repository = ConnectionRepository(database.professionalExperienceDao(), database.followersDao(),database.userDao())
        val sharedPreferences = requireActivity().getSharedPreferences(CustomSharedPreferences.NAME, Context.MODE_PRIVATE)
        val userId =  sharedPreferences.getLong(CustomSharedPreferences.LOGGED_IN_USER_ID, -1)

        viewModel = ViewModelProvider(requireActivity(),ConnectionViewModelFactory(repository, userId)).get(ConnectionsViewModel::class.java)
        if(!viewModel.followers.isInitialized)
            viewModel.initializeFollowers()
        val adapter = ConnectionsAdapter(this) { index ->
            val directions =
                ConnectionsFragmentDirections.actionConnectionsFragmentToBottomSheetFragment(index)
            findNavController().navigate(directions)
            //setMenuVisibility(true)
        }
        setFragmentResultListener("Index") { key, bundle -> // setting the listener to respond to unfollow in bottomn sheet fragment
            println(" event responded")
            val index = bundle.getInt("Index")
            if (index != -1) {

                //println("III $id")

                //viewModel.unFollow(id, index)

            }
        }
        //binding.topAppBar.inflateMenu(R.menu.search_menu)
        viewModel.followers.observe(viewLifecycleOwner) {
            it?.let { adapter.submitList(it) }
        }
        viewModel.followers.value
        binding.connections.adapter = adapter
        setUpSearchFeature()
        return binding.root
    }
    private fun setUpSearchFeature(){
        menuProvider = object: MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_icon,menu)
                val searchfun  = menu.findItem((R.id.action_search))
                val searchView :SearchView = searchfun.actionView as SearchView
                //searchView.setOnCloseListener({true})

                searchView.queryHint ="Search Users"
                //searchView.set
                searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        query?.let{
                           val searchResults = viewModel.search(query)
                            val directions = ConnectionsFragmentDirections.actionConnectionsFragmentToSearchFragment()
                            findNavController().navigate(directions)
                        }


                        return true
                    }
                    override fun onQueryTextChange(query: String?): Boolean {
                        binding.connections.visibility = GONE
                        binding.loadingProgressBar.visibility = VISIBLE
                        return true
                    }

                })
                searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
                    binding.connections.visibility = VISIBLE
                    binding.loadingProgressBar.visibility = GONE
                }
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.action_search -> return true
                    else -> {
                        Log.d("TAG", "backpressed: $menuItem.itemId")
                    }
                }
                return false
            }
        }
        (requireActivity() as MenuHost).addMenuProvider(menuProvider, viewLifecycleOwner)
    }
    override fun onPause(){
        super.onPause()
        println("I am inside the onPause ConnectionsFragment")
    }
    override fun onDestroy() {
        super.onDestroy()
        println("I am deleted in the connections Fragment")
        _binding = null
    }
    override fun onResume() {
        super.onResume()
        println("connections Fragment on focus")
    }
}