package com.example.hirein.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hirein.data.entity.ConnectionsAdapter
import com.example.hirein.databinding.FragmentConnectionsBinding

class ConnectionsFragment:Fragment() {
    private  var _binding: FragmentConnectionsBinding? = null
    private val binding get() =_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentConnectionsBinding.inflate(inflater,container,false)
         val adapter = ConnectionsAdapter()
        binding.connections.adapter = adapter
        val view = binding.root
        println("I am recreated connection")
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        println("connections Fragment on focus")
    }
}