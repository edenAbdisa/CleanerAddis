package com.iyoa.cleanaddis.data.news

import java.util.*

data class ArticleData(
    var title:String,
    var media_uuid:UUID,
    var text:String,
    var published_date:Date,
    var view_count:Int,
    var category_uuid:UUID
                   ) {




}