package com.iyoa.cleanaddis.data.common

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Address")
data class Address(
    @PrimaryKey
    @ColumnInfo(name="uuid")
    val uuid: Long,


    @ColumnInfo(name = "subcity") val subcity:String,

    @ColumnInfo(name="woreda")val woreda:String,

    @ColumnInfo(name="street_name")val streetName:String
)
