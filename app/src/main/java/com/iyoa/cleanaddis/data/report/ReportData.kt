package com.iyoa.cleanaddis.data.report

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.*

data class ReportData(
    val username:String,
    val subject:String,
    val mediaUUID:Long,
    val reportType:String,
    val date: Date,
    val address_uuid: Long,
    val impact:Int
) {
}
