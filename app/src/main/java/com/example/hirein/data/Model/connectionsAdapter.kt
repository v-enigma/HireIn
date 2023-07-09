package com.example.hirein.data.Model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.R
import de.hdodenhof.circleimageview.CircleImageView

class ConnectionsAdapter: RecyclerView.Adapter<ConnectionsAdapter.ConnectionViewHolder>() {
    var connections :List<User> = listOf()
    class ConnectionViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var profileImage : CircleImageView = itemView.findViewById(R.id.profilePhoto)
        var userName :TextView = itemView.findViewById(R.id.personName)
        var roleDetails :TextView = itemView.findViewById(R.id.roleDetails)
         companion object {
             fun inflateFrom(parent: ViewGroup):ConnectionViewHolder{
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val view = layoutInflater.inflate(R.layout.connections_view,parent,false) as RelativeLayout
                 return ConnectionViewHolder(view)
             }
         }
        fun bind(item: UserDetails){


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectionViewHolder = ConnectionViewHolder.inflateFrom(parent)

    override fun getItemCount(): Int {
       return connections.size
    }

    override fun onBindViewHolder(holder: ConnectionViewHolder, position: Int) {
        val item = connections[position]
        if(!item.userDetails.profilePhoto.isEmpty()){
            val bitmap = BitmapFactory.decodeFile(item.userDetails.profilePhoto)
            holder.profileImage.setImageBitmap(bitmap)
        }
        holder.userName.text = "${item.userDetails.firstName} ${item.userDetails.lastName}"
        if(item.experiences.isNotEmpty()){
            var roleDetails = "${item.experiences.get(0).title} at ${item.experiences[0].company.name}| "
            if(item.experiences[0].skills.isNotEmpty()){
                item.experiences[0].skills.forEach{
                    roleDetails = "$roleDetails| $it"

                }

            }
          holder.roleDetails.text = roleDetails
        }


    }

}