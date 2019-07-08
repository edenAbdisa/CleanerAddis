package com.iyoa.cleanaddis.data.news

<<<<<<< HEAD
import androidx.room.*
=======
import java.util.*
>>>>>>> parent of 77bccfc... Article feature modified

data class ArticleData(
    var title:String,
    var media_uuid:UUID,
    var text:String,
    var published_date:Date,
    var view_count:Int,
    var category_uuid:UUID
                   ) {




}