package com.iyoa.cleanaddis.utility

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtility {
    companion object {
        fun getCurrentDate(): String {
            val current = LocalDateTime.now()

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
            val formatted = current.format(formatter)
            return formatted
        }
    }
}