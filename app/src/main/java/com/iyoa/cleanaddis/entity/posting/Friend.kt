package com.iyoa.cleanaddis.entity.posting

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class FriendRequestStatus{
    REQUESTED,ACCEPTED,REMOVED
}

@Entity(tableName = "friend")
data class Friend(
                    @PrimaryKey
                   val uuid:Long,
                   val status:String,
                   val username_requestor:String,
                   val username_acceptor:String) {
}