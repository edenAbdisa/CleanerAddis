package com.iyoa.cleanaddis.data.common


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "role")
data class Role(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="uuid")
    val uuid: Long,

    @ColumnInfo(name="role") val role:String




):Serializable {


}