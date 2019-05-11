package com.example.abigail.cleanaddis.entity.posting

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "post")
data class Post(
    @PrimaryKey @ColumnInfo(name = "post_uuid") val uuid: UUID,
    @ColumnInfo(name="post_username") val username:String,
    @ColumnInfo(name = "post_no_likes") val noLike:Int,
    @ColumnInfo(name="media_path") val mediaPath:String): Serializable {
}