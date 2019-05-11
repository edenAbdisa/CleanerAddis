package com.example.abigail.cleanaddis.entity.new

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "news")
data class News(
    @PrimaryKey @ColumnInfo(name = "news_uuid") val code:UUID,
    @ColumnInfo(name="news_title") val title:String,
    @ColumnInfo(name = "news_text") val text:String,
    @ColumnInfo(name="image_path") val imagePath:String): Serializable {
}