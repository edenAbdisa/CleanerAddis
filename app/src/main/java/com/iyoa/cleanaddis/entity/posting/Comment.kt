package com.iyoa.cleanaddis.entity.posting


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


data class Comment ( val text:String,
                 val postUuid:String, val status: String,  val noLike: Int,
                 val commenterUuid:String,
                 val date:String)
