package com.iyoa.cleanaddis.data.posting


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


enum class CommentStatus {
    REPLIED,UPDATED
}

@Entity(tableName = "comment")
data class CommentUUID (@PrimaryKey val  uuid: String, val text:String,
                        val postUuid:String, val status: String, val noLike: Int,
                        val commenterUuid:String,
                        val date:Date)
