package com.iyoa.cleanaddis.entity.posting


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*
/*
enum class PostStatus {
   POSTED, REMOVEDBYREPORT,DELETED,EDITED
}
enum class CanBeViewedBy {
    FRIENDS,FRIENDSOFFRIENDS,MEONLY,ALL
}
val can_be_viewed_by:Enum<CanBeViewedBy>,
val status: Enum<PostStatus>,
val date:Date,
*/
@Entity(tableName = "post")
data class Post (@PrimaryKey val  uuid: Long, val username:String,
                 val noLike:Int, val no_view: Int,  val downloadable: Int,
                 val allow_to_be_used_for_article:Int,
                 val media_uuid:Long, val category_uuid:Long)