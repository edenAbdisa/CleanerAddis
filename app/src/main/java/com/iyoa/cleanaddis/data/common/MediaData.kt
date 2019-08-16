package com.iyoa.cleanaddis.data.common

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class MediaData(
    val url:String,
    val type: String,
    val forWhatData:String,
    val description:String
) {
}