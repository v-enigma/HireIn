package com.example.hirein.data

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.data.entity.ConnectionsAdapter
import com.example.hirein.databinding.ConnectionBinding


class SearchResultsAdapter() : ListAdapter<ConnectionInfromation, SearchResultsAdapter.SearchItemViewHolder>(ConnectionsDiffItemCallback()) {

    class SearchItemViewHolder(val binding: ConnectionBinding):RecyclerView.ViewHolder(binding.root){
        companion object{
            fun inflateFrom(parent:ViewGroup): SearchItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ConnectionBinding.inflate(layoutInflater,parent,false)
                return SearchItemViewHolder(binding)
            }
        }
        fun bind(item:ConnectionInfromation){
            binding.connection = item
            binding.options.visibility = GONE
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder = SearchItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }
}
