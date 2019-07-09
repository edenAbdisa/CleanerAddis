package com.iyoa.cleanaddis.data.report

data class ReportData(
    val username:String,
    val subject:String,
    val mediaUUID: String,
    val reportType:String,
    val date: Long,
    val address_uuid: Long,
    val impact:Int
) {
}
