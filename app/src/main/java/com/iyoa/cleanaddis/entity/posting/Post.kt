package com.iyoa.cleanaddis.entity.posting


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


 data class Post ( val username:String,
                 val noLike:Int, val noView: Int,  val downloadable: Int,
                 val allowToBeUsedForArticle:Int,
                 val mediaUuid:String, val categoryUuid:String,val canBeViewedBy:String,
                 val status: String ,
                 val date:String)
