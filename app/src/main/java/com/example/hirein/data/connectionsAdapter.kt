package com.example.hirein.data.entity

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.R
import com.example.hirein.data.ConnectionInfromation
import com.example.hirein.data.ConnectionsDiffItemCallback
import com.example.hirein.databinding.ConnectionBinding
import de.hdodenhof.circleimageview.CircleImageView

class ConnectionsAdapter(val onItemClicked: (Int)-> Unit): ListAdapter<ConnectionInfromation, ConnectionsAdapter.ConnectionViewHolder>(
    ConnectionsDiffItemCallback()
){
   // val date = LocalDate(1998,2,1)

  // private var connections  = connections.value

    class ConnectionViewHolder(val binding: ConnectionBinding):RecyclerView.ViewHolder(binding.root){
        val options : ImageView = binding.options
         companion object {
             fun inflateFrom(parent: ViewGroup):ConnectionViewHolder{
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = ConnectionBinding.inflate(layoutInflater,parent,false)
                 //val view = layoutInflater.inflate(R.layout.connection,parent,false) as ConstraintLayout
                 return ConnectionViewHolder(binding )
             }
         }
        fun bind(item: ConnectionInfromation){
        binding.connection = item
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectionViewHolder {

        val viewHolder = ConnectionViewHolder.inflateFrom(parent)
        // println("I am inside viewHolder")
        viewHolder.options.setOnClickListener{
            onItemClicked(viewHolder.adapterPosition)
        }
       return viewHolder
    }


    @RequiresApi(Build.VERSION_CODES.O)
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