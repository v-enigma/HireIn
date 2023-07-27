package com.example.hirein.data

import androidx.recyclerview.widget.DiffUtil

class ConnectionsDiffItemCallback: DiffUtil.ItemCallback<ConnectionInformation>() {
    override fun areItemsTheSame(
        oldItem: ConnectionInformation,
        newItem: ConnectionInformation
    ): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: ConnectionInformation,
        newItem: ConnectionInformation
    ): Boolean  = oldItem == newItem
}