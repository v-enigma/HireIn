package com.example.hirein.data


import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.databinding.ConnectionBinding

class SearchLineResultAdapter(val type:String): ListAdapter<ConnectionInformation, SearchLineResultAdapter.SearchLineResultViewHolder>(
    SearchLineResultDiffItemCallBack()
) {
    private lateinit var  binding : ConnectionBinding
    class SearchLineResultViewHolder(val binding:ConnectionBinding, val type:String): RecyclerView.ViewHolder(binding.root) {

        fun bind(item :ConnectionInformation){
            binding.connection = item
            binding.options.visibility = GONE
            if(type != "Follower"){
                binding.follow.visibility = VISIBLE
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchLineResultViewHolder {
        binding = ConnectionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchLineResultViewHolder(binding,type)

    }

    override fun onBindViewHolder(holder: SearchLineResultViewHolder, position: Int) {
        val item = getItem(position)
        item.let{holder.bind(item)}
    }
}