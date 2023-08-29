package com.example.hirein.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.data.SearchResultsDiffItemCallBack
import com.example.hirein.data.model.SearchResults
import com.example.hirein.databinding.SearchLineItemBinding

class SearchResultsAdapter: ListAdapter<SearchResults, SearchResultsAdapter.SearchResultsViewHolder>(
    SearchResultsDiffItemCallBack()
){
   private lateinit var binding: SearchLineItemBinding
    class SearchResultsViewHolder(val binding: SearchLineItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item :SearchResults){
            binding.searchResult = item
            binding.categoryResults.adapter = SearchLineResultAdapter(item.name)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultsViewHolder {
        binding = SearchLineItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchResultsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SearchResultsViewHolder, position: Int) {
        val item = getItem(position)
        item.let{holder.bind(item)}
    }
}