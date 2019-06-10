package com.iyoa.cleanaddis.entity.posting


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


enum class CommentStatus {
    REPLIED,UPDATED
}

@Entity(tableName = "comment")
data class Comment (@PrimaryKey val  uuid: String, val text:String,
                 val postUuid:String, val status: CommentStatus,  val noLike: Int,
                 val commenterUuid:String,
                 val date:Date)
