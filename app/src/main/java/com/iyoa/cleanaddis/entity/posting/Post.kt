package com.iyoa.cleanaddis.entity.posting


import java.io.Serializable
import java.util.*



data class Post (val uuid: String, val username:String, val noLike:Int,
                 val mediaPath:String)