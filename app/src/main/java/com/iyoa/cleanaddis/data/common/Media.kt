package com.iyoa.cleanaddis.data.common


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "media")
data class Media(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="uuid")
    val uuid: Long,

    @ColumnInfo(name="url") val url:String,
    @ColumnInfo(name="type")val type: String,
    @ColumnInfo(name = "for_what_data") val forWhatData:String,

    @ColumnInfo(name="description")val description:String

):Serializable {


}