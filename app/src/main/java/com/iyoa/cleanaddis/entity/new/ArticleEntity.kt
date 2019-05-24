package com.iyoa.cleanaddis.entity.new

import com.iyoa.cleanaddis.data.news.ArticleData
import java.util.*

 class ArticleEntity{



    fun generateArticle(
        title:String="",
        media_uuid: UUID=UUID.randomUUID(),
        text:String="",
        published_date:Date= Date(2019),
        view_count:Int=0,
        category_uuid:UUID= UUID.randomUUID()): ArticleData {

        return ArticleData(title,media_uuid,text,published_date,
            view_count,category_uuid)

    }



}