package com.example.hirein.data.DB.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
     foreignKeys = [
          ForeignKey(
               entity = Company::class,
               parentColumns = ["companyId"],
               childColumns = ["companyId"],
               onDelete = ForeignKey.CASCADE
          )
     ]
)
data class Address(
     @PrimaryKey(autoGenerate = true)
     val addressId :Long = 0,
     val plotNo:String,
     val street :String,
     val landMark :String,
     val district:String,
     val state: String,
     val country :String,
     val pincode :Int,
     val companyId: Long)
{

}