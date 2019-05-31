package com.iyoa.cleanaddis.data.news

import android.text.style.TtsSpan
import androidx.annotation.IdRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Entity(tableName = "article")
data class Article(
    @PrimaryKey
@ColumnInfo(name="uuid")
<<<<<<< HEAD
val uuid: Long,
=======
val uuid: Long ,
>>>>>>> 61b9985b276e148cf22369ad1bfdeb5b11542bc6
    @ColumnInfo(name="title") val title:String,
    @ColumnInfo(name="media_uuid")val media_uuid: String,
    @ColumnInfo(name = "text") val text:String,

    @ColumnInfo(name="published_date")val published_date:String,
    @ColumnInfo(name="published_status")val published_status: String,
    @ColumnInfo(name="updated_by")val updated_by: String,
    @ColumnInfo(name="published_by") val published_by:String,
    @ColumnInfo(name="view_count")val view_count:Integer,
    @ColumnInfo(name = "category_uuid")val category_uuid: String
):Serializable {


}