package com.iyoa.cleanaddis.data.posting

import androidx.room.PrimaryKey
import com.iyoa.cleanaddis.data.common.MediaJSON
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.squareup.moshi.Json

data class PostJSON(
    @Json(name="uuid") val  uuid: String,
    @Json(name="username") val username:String,
    @Json(name="noLike") val noLike:Int, @Json(name="uuid") val noView: Int,
    @Json(name="downloadable") val downloadable: Int,
    @Json(name="allowToBeUsedForArticle") val allowToBeUsedForArticle:Int,
    @Json(name="media") var media: MediaJSON,
    @Json(name="canBeViewedBy") val canBeViewedBy:String,
    @Json(name="status") val status: String,
    @Json(name="date") val date:String,
    @Json(name="comment") val comments: List<CommentJSON>){

}
