package com.iyoa.cleanaddis.data.common

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.iyoa.cleanaddis.data.posting.LabelUUID
import com.squareup.moshi.Json

data class MediaJSON (

    @Json(name="uuid")
    val uuid: String,

    @Json(name="url") val url:String,
    @Json(name="type")val type: String,
    @Json(name = "label") val label:LabelUUID,

    @Json(name="description")val description:String
){}