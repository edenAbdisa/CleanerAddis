package com.iyoa.cleanaddis.entity.posting

import java.util.*

class PostTest {
    fun generatePost(  uuid: String,  username:String,
                      noLike:Int,  noView: Int,   downloadable: Int,
                      allowToBeUsedForArticle:Int,
                      mediaUuid:String,  categoryUuid:String, can_be_viewed_by:String,
                      status: String ,
                      date: Date
    ){}

    fun generateComment(  uuid: String,  text:String,
                           postUuid:String,  status: CommentStatus,   noLike: Int,
                           commenterUuid:String,
                           date:Date
    ){}
}