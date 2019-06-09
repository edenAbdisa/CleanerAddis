package com.iyoa.cleanaddis.utility


import java.util.*
import androidx.room.TypeConverter
import com.iyoa.cleanaddis.entity.posting.CanBeViewedBy
import com.iyoa.cleanaddis.entity.posting.FriendRequestStatus
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