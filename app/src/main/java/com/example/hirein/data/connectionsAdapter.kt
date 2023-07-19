package com.example.hirein.data.entity

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.R
import com.example.hirein.data.ConnectionInfromation
import com.example.hirein.data.UserDetails
import de.hdodenhof.circleimageview.CircleImageView

class ConnectionsAdapter(val onItemClicked: (Int)-> Unit, connections: LiveData<List<ConnectionInfromation>>): RecyclerView.Adapter<ConnectionsAdapter.ConnectionViewHolder>() {
   // val date = LocalDate(1998,2,1)

   private var connections  = connections.value

    class ConnectionViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var profileImage : CircleImageView = itemView.findViewById(R.id.profilePhoto)
        var userName :TextView = itemView.findViewById(R.id.personName)
        var roleDetails :TextView = itemView.findViewById(R.id.roleDetails)
        val options : ImageView = itemView.findViewById(R.id.options)
         companion object {
             fun inflateFrom(parent: ViewGroup):ConnectionViewHolder{
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val view = layoutInflater.inflate(R.layout.connection,parent,false) as ConstraintLayout
                 return ConnectionViewHolder(view)
             }
         }
        fun bind(item: ConnectionInfromation){
          //this.roleDetails.text =  dao issues
            this.roleDetails.text = "${item.roleName}  @ ${item.companyName} "
          this.userName.text = "${item.firstName} ${item.lastName} "
          //this.profileImage =  // have to request storage permission and look how to create a photo from the storage path

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectionViewHolder {
        val viewHolder = ConnectionViewHolder.inflateFrom(parent)
        // println("I am inside viewHolder")
        viewHolder.options.setOnClickListener(View.OnClickListener {

           this.onItemClicked(viewHolder.adapterPosition)
        })

       return viewHolder
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun getItemCount(): Int {
        val count = connections?.size ?: 0
        if(count ==0 )
            println("Empty list")
        return connections?.size ?: 0
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ConnectionViewHolder, position: Int) {
        //println("$position of the view")
        val item = connections?.get(position)
        item?.let { holder.bind(it) }
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