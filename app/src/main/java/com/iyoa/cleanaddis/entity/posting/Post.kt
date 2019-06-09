package com.iyoa.cleanaddis.entity.posting


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

enum class PostStatus {
   POSTED, REMOVEDBYREPORT,DELETED,EDITED
}
enum class CanBeViewedBy {
    FRIENDS,FRIENDSOFFRIENDS,MEONLY,ALL
}
/**
@Entity(tableName = "post")
data class Post (@PrimaryKey val  uuid: Long, val username:String,
                 val noLike:Int, val noView: Int,  val downloadable: Int,
                 val allowToBeUsedForArticle:Int,
                 val mediaUuid:Long, val categoryUuid:Long,val can_be_viewed_by:String,
                 val status: String ,
                 val date:Date)
        **/