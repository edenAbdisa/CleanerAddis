package com.iyoa.cleanaddis.data.news

import androidx.room.*


@Entity(tableName = "article")
data class ArticleData(
    @PrimaryKey
    @ColumnInfo(name="uuid")
    var uuid:String,
    @ColumnInfo(name="title")
    var title:String,
    @ColumnInfo(name="media_uuid")
    var media_uuid:String,
    @ColumnInfo(name="text")
    var text:String,
    @ColumnInfo(name="published_date")
    var published_date:Long?,
    @ColumnInfo(name="view_count")
    var view_count:Int,
    @ColumnInfo(name="category_uuid")
    var category_uuid:String
                   )










