package com.iyoa.cleanaddis.entity.user

import java.util.*

data class User(
    var username:String,var password: String,
    var activated: Int, var blocked: Int, var lastVisit: Date, var
            activated_date: Date
) {
}