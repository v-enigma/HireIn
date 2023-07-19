package com.example.hirein.UI

import androidx.recyclerview.widget.DiffUtil
import com.example.hirein.data.ConnectionInfromation

class ConnectionsDiffItemCallback: DiffUtil.ItemCallback<ConnectionInfromation>() {
    override fun areItemsTheSame(
        oldItem: ConnectionInfromation,
        newItem: ConnectionInfromation
    ): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: ConnectionInfromation,
        newItem: ConnectionInfromation
    ): Boolean  = oldItem == newItem
}