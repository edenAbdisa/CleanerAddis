package com.iyoa.cleanaddis.data.teaching

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "category")
data class Category(
    @PrimaryKey
    @ColumnInfo(name="uuid") val uuid : Long,

    @ColumnInfo(name="name") val name:String,
    @ColumnInfo(name="for_what")val for_what: String




) : Serializable{

}
