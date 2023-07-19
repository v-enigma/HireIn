package com.example.hirein.UI

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.hirein.R
import com.example.hirein.data.ConnectionsViewModel
import com.example.hirein.data.entity.ConnectionsAdapter
import com.example.hirein.databinding.FragmentConnectionsBinding

class ConnectionsFragment:Fragment() {
    private  var _binding: FragmentConnectionsBinding? = null
    private val binding get() =_binding!!
    private lateinit var viewModel: ConnectionsViewModel
    @RequiresApi(Build.VERSION_CODES.O)

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
        binding.topAppBar.inflateMenu(R.menu.search_menu)

        viewModel.followers.observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it) }
        })
        binding.connections.adapter = adapter

        return binding.root
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