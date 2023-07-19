package com.example.hirein.UI

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
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

        val adapter = ConnectionsAdapter( onItemClicked = { index ->
            val directions =
                ConnectionsFragmentDirections.actionConnectionsFragmentToBottomSheetFragment(index)
            findNavController().navigate(directions)
            setMenuVisibility(true)
        }, viewModel.getData()
        )
        binding.connections.adapter = adapter

        //println("I am recreated connection")
        binding.topAppBar.inflateMenu(R.menu.search_menu)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        println("I am recreated")
        super.onCreate(savedInstanceState)
      setFragmentResultListener("Index") { key, bundle ->
            println(" event responded")
            val index = bundle.getInt("Index")
            if (index != -1) {
                viewModel.deleteFollower(index)
            }
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        println("I am deleted")
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        println("connections Fragment on focus")
    }

}