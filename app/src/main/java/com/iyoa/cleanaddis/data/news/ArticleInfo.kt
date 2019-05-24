package com.iyoa.cleanaddis.data.news

import java.util.*

data class ArticleInfo(
    var article_uuid: String,
    var  published_status: String, var updated_by: String,
    var updated_date:Date, var published_by: String

) {
}