package com.iyoa.cleanaddis.entity.user

import java.util.*

data class User(
    var uuid:String,
    var username:String,var password: String,
    var activated: Int, var blocked: Int
) {
}