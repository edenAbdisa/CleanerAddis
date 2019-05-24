package com.iyoa.cleanaddis.entity.new


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "article")
data class News(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uuid") val code:UUID,
    @ColumnInfo(name="title") val title:String,
    @ColumnInfo(name="media_uuid")val media_uuid: UUID,
    @ColumnInfo(name = "text") val text:String,
    @ColumnInfo(name="published_date")val published_date:Date,
    @ColumnInfo(name="view_count")val view_count:Integer,
    @ColumnInfo(name = "category_uuid")val category_uuid:UUID
    ): Serializable {
}