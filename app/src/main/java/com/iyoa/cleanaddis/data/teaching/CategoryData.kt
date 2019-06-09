package com.iyoa.cleanaddis.data.teaching

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryData (
    @PrimaryKey
    @ColumnInfo(name="uuid")
    var uuid:String,
    @ColumnInfo(name="name")
    var name:String,
    @ColumnInfo(name="for_what")
    var for_what:String

)