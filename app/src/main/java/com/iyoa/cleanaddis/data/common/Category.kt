package com.iyoa.cleanaddis.data.common


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="uuid")
    val uuid: Long,

    @ColumnInfo(name="name") val url:String,

    @ColumnInfo(name = "for_what_data") val forWhatData:String



):Serializable {


}