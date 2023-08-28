package com.example.hirein.data.entity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.UI.ConnectionsFragmentDirections
import com.example.hirein.data.ConnectionInformation
import com.example.hirein.data.ConnectionsDiffItemCallback
import com.example.hirein.databinding.ConnectionBinding

class ConnectionsAdapter(val fragment: Fragment, val onOptionsClicked: (Int)-> Unit): ListAdapter<ConnectionInformation, ConnectionsAdapter.ConnectionViewHolder>(
    ConnectionsDiffItemCallback()
){

    class ConnectionViewHolder(val binding: ConnectionBinding):RecyclerView.ViewHolder(binding.root){
        val options : ImageView = binding.options

         companion object {
             fun inflateFrom(parent: ViewGroup):ConnectionViewHolder{
                 val binding = ConnectionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                 //val view = layoutInflater.inflate(R.layout.connection,parent,false) as ConstraintLayout
                 return ConnectionViewHolder(binding)
             }
         }
        fun bind(item: ConnectionInformation){
            binding.connection = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectionViewHolder {

        val viewHolder = ConnectionViewHolder.inflateFrom(parent)
        // println("I am inside viewHolder")
        viewHolder.options.setOnClickListener{
            onOptionsClicked(viewHolder.adapterPosition)
        }
       return viewHolder
    }



//    override fun getItemCount(): Int {
//        val count = connections?.size ?: 0
//        if(count ==0 )
//            println("Empty list")
//        return connections?.size ?: 0
//    }


    override fun onBindViewHolder(holder: ConnectionViewHolder, position: Int) {
        //println("$position of the view")
        val item = getItem(position)
        holder.bind(item)
        holder.binding.root.setOnClickListener{
            val directions = ConnectionsFragmentDirections.actionConnectionsFragmentToProfileFragment(item.id)
            findNavController(fragment).navigate(directions)
        }

/*        if(!item.profilePhoto.isEmpty()){
            val bitmap = BitmapFactory.decodeFile(item.profilePhoto)
            holder.profileImage.setImageBitmap(bitmap)
        }
        holder.userName.text = "${item.firstName} ${item.lastName}"
        *//*if(item.experiences.isNotEmpty()){
            var roleDetails = "${item.experiences.get(0).title} at ${item.experiences[0].company.name}| "
            if(item.experiences[0].skills.isNotEmpty()){
                item.experiences[0].skills.forEach{
                    roleDetails = "$roleDetails| $it"

                }

            }
          holder.roleDetails.text = roleDetails
        }
*/
    }


}