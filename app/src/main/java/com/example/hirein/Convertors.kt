package com.example.hirein

import androidx.room.TypeConverter
import java.util.*

class Convertors {

  @TypeConverter
  fun timeStampToDate(dateLong: Long?): Date? {
    return dateLong?.let{Date(it)
    }
  }
  @TypeConverter
  fun dateToTimeStamp(date:Date?):Long?{
      return date?.time?.toLong()
  }

  @TypeConverter
  fun  booleanToInt(value:Boolean):Int{
      return when(value){
           true -> 1
            else -> 0
      }
  }
  @TypeConverter
  fun intToBoolean(value: Int):Boolean  {
      return value == 1
      }
  }