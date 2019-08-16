package com.iyoa.cleanaddis.data.posting

import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.util.*

data class CommentJSON(@Json(name="uuid") val  uuid: String,
                       @Json(name="text") val text:String,
                       @Json(name="post") val  postUuid: String,
                       @Json(name="status") val status: String,
                       @Json(name="noLike") val noLike: Int,
                       @Json(name="user") val commenterUuid:String,
                       @Json(name="commentDate") val date: String
){}