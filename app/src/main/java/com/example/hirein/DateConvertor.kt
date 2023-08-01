package com.example.hirein

import android.icu.text.SimpleDateFormat
import android.text.format.DateFormat
import androidx.room.TypeConverter
import java.util.*

object DateConvertor {
  @JvmStatic
  fun toDate(dateLong: Long): String {
    return dateLong.let{
     val format = SimpleDateFormat("yyyy MMM", Locale.getDefault())
     format.format(dateLong)
    }
  }
}