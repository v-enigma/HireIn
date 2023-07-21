package com.example.hirein.UI

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hirein.R
import com.example.hirein.data.ConnectionInfromation
import com.example.hirein.data.ConnectionsViewModel
import com.example.hirein.data.entity.ConnectionsAdapter
import com.example.hirein.databinding.FragmentConnectionsBinding


class ConnectionsFragment:Fragment() {
    private  var _binding: FragmentConnectionsBinding? = null
    private val binding get() =_binding!!
    private lateinit var viewModel: ConnectionsViewModel
    private lateinit var menuProvider:MenuProvider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentConnectionsBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(ConnectionsViewModel::class.java)
        viewModel.getData() // to intialize static data
        setFragmentResultListener("Index") { key, bundle -> // setting the listener to respond to unfollow in bottomn sheet fragment
            println(" event responded")
            val index = bundle.getInt("Index")
            if (index != -1) {
                viewModel.deleteFollower(index)
            }
        }
        val adapter = ConnectionsAdapter { index ->
            val directions =
                ConnectionsFragmentDirections.actionConnectionsFragmentToBottomSheetFragment(index)
            findNavController().navigate(directions)
            //setMenuVisibility(true)

        }

        //binding.topAppBar.inflateMenu(R.menu.search_menu)

        viewModel.followers.observe(viewLifecycleOwner) {
            it?.let { adapter.submitList(it) }
        }
        binding.connections.adapter = adapter

        return binding.root
    }
    override fun onStart(){
        super.onStart()
        menuProvider = object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.search_icon,menu)
                val searchfun  = menu.findItem((R.id.action_search))
                val searchView :SearchView = searchfun.actionView as SearchView

               // searchView.setIconifiedByDefault(false)
                searchView.queryHint ="Search Users"
                searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
                    override fun onQueryTextSubmit(query: String?): Boolean {

                        return true
                    }


                    override fun onQueryTextChange(query: String?): Boolean {
                        viewModel.search(query)
                        //val directions = ConnectionsFragmentDirections.actionConnectionsFragmentToSearchFragment()
                        //findNavController().navigate(directions)
                        return true
                    }
                })
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.action_search ->return true
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