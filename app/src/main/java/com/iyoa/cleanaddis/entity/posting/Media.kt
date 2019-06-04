package com.iyoa.cleanaddis.entity.posting

enum class MediaType{
    VIDEO,IMAGE,VOICE
}
data class Media(val uuid:Long,
                 val url:String,
                 val mediaType:Enum<MediaType>,
                 val forWhatData:String,
                 val description:String) {
}