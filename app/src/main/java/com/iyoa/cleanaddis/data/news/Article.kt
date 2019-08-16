package com.iyoa.cleanaddis.data.news


import androidx.room.*
import com.iyoa.cleanaddis.utility.DataConverter
import java.io.Serializable
import java.util.*

@Entity(tableName = "article")
data class Article(
    @PrimaryKey
    @ColumnInfo(name="uuid")
    val uuid: String,
    @ColumnInfo(name="title") val title:String,
    @ColumnInfo(name="media_uuid")val media_uuid: Long,
    @ColumnInfo(name = "text") val text:String,
    @ColumnInfo(name="published_date")val published_date: String?,
    @ColumnInfo(name="view_count")val view_count:Int,
    @ColumnInfo(name = "category_uuid")val category_uuid: Long
):Serializable {


}