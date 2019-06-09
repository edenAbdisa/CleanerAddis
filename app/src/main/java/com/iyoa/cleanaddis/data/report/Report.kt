package com.iyoa.cleanaddis.data.report

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "report")
data class Report
    (
    @PrimaryKey
    @ColumnInfo(name="uuid")
    val uuid: Long,
    @ColumnInfo(name="username")
    val username:String,
    @ColumnInfo(name = "subject")
    val subject:String,
    @ColumnInfo(name="media_uuid")
    val mediaUUID:Long,
    @ColumnInfo(name="report_type")
    val reportType:String,
    @ColumnInfo(name="date")
    val date: Date,
    @ColumnInfo(name="address_uuid")
    val address_uuid: Long,
    @ColumnInfo(name="impact")
    val impact:Int

    )
{
}