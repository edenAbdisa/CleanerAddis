package com.iyoa.cleanaddis.entity.common


import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


data class Media(

     val url:String,
    val type: String,
     val forWhatData:String,
    val description:String

):Serializable {


}