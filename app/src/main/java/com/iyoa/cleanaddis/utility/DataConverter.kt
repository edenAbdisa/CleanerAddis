package com.iyoa.cleanaddis.utility


import java.util.*
import androidx.room.TypeConverter
import com.iyoa.cleanaddis.data.posting.CanBeViewedBy
import com.iyoa.cleanaddis.data.posting.FriendRequestStatus
import java.io.Serializable
import java.time.format.DateTimeFormatter

class DataConverter : Serializable{

    companion object {
        private val FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?): Long? {
            return date?.time?.toLong()
        }
        @TypeConverter
        @JvmStatic
        fun fromTimestamp(value: Long?): Date? {

            return value?.let{Date(it)}
        }

        @TypeConverter
        @JvmStatic
        public fun fromInstant(value: Date): Long {
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

        @TypeConverter
        @JvmStatic
        fun toString(value:Enum<FriendRequestStatus>):String{
            return value.toString()
        }
        @TypeConverter
        @JvmStatic
        fun enumToString(value:Enum<CanBeViewedBy>):String{
            return value.toString()
        }

    }


}