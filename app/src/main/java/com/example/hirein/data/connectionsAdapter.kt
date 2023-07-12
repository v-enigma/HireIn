package com.example.hirein.data.entity

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.hirein.R
import de.hdodenhof.circleimageview.CircleImageView
import java.time.LocalDate

class ConnectionsAdapter: RecyclerView.Adapter<ConnectionsAdapter.ConnectionViewHolder>() {
   // val date = LocalDate(1998,2,1)
   @RequiresApi(Build.VERSION_CODES.O)
   var connections :List<User> = listOf(
        User(1, firstName = "A", lastName = "B", mobileNo = "123", emailId = "venu@1234", LocalDate.now(), " ", " " )
               , User(1, firstName = "A", lastName = "B", mobileNo = "123", emailId = "venu@1234", LocalDate.now(), " ", " " )   ,
       User(1, firstName = "A", lastName = "B", mobileNo = "123", emailId = "venu@1234", LocalDate.now(), " ", " " )
   )
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
        fun bind(item: User){
          //this.roleDetails.text =  dao issues
          this.userName.text = "${item.firstName} ${item.lastName}"
          //this.profileImage =  // have to request storage permission and look how to create a photo from the storage path

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectionViewHolder = ConnectionViewHolder.inflateFrom(parent)

    override fun getItemCount(): Int {
       return connections.size
    }

    override fun onBindViewHolder(holder: ConnectionViewHolder, position: Int) {
        val item = connections[position]
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