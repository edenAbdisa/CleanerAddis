package com.iyoa.cleanaddis.utility


import java.util.*
import androidx.room.TypeConverter
import java.io.Serializable
import java.time.Instant

class DataConverter:Serializable{
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromInstant(value: Date): Long {
            return value.time
        }

        @TypeConverter
        @JvmStatic
        fun toInstant(value: Long): Date {
            return Date(value)
        }

        @TypeConverter
        @JvmStatic
        fun toString(value:UUID):String{
            return value.toString()
        }
    }


}