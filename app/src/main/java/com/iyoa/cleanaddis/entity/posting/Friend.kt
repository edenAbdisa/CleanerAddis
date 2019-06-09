package com.iyoa.cleanaddis.entity.posting

import androidx.room.Entity

enum class FriendRequestStatus{
    REQUESTED,ACCEPTED,REMOVED
}
@Entity(tableName = "friend")
data class Friend(val uuid:Long,
                   val status:Enum<FriendRequestStatus>,
                   val username_requestor:String,
                   val username_acceptor:String) {
}