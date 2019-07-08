package com.iyoa.cleanaddis.data.news

<<<<<<< HEAD

import androidx.room.*
import com.iyoa.cleanaddis.utility.DataConverter
=======
import android.text.style.TtsSpan
import androidx.annotation.IdRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
>>>>>>> parent of 77bccfc... Article feature modified
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
    val uuid: String,

>>>>>>> parent of 77bccfc... Article feature modified
    @ColumnInfo(name="title") val title:String,
    @ColumnInfo(name="media_uuid")val media_uuid: Long,
    @ColumnInfo(name = "text") val text:String,
<<<<<<< HEAD
    @ColumnInfo(name="published_date")val published_date: Date,
=======

    @ColumnInfo(name="published_date")val published_date:String,
    @ColumnInfo(name="published_status")val published_status: String,
    @ColumnInfo(name="updated_by")val updated_by: String,
    @ColumnInfo(name="published_by") val published_by:String,
>>>>>>> parent of 77bccfc... Article feature modified
    @ColumnInfo(name="view_count")val view_count:Int,
    @ColumnInfo(name = "category_uuid")val category_uuid: Long
):Serializable {


}