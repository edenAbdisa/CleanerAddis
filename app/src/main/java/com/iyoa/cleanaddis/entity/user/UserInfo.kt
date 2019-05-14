package com.iyoa.cleanaddis.entity.user

import android.provider.ContactsContract
import com.google.common.collect.MapMaker

data class UserInfo(
    var name: Map<String,String>,var email: String, var phone_number: String
, var image_url:String

) {


}