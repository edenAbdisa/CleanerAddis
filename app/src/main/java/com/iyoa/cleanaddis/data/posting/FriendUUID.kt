package com.iyoa.cleanaddis.data.posting

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class FriendRequestStatus{
    REQUESTED,ACCEPTED,REMOVED
}

@Entity(tableName = "friend")
data class FriendUUID(
                    @PrimaryKey
                   val uuid:String,
                   val status:String,
                   val username_requestor:String,
                   val username_acceptor:String) {
}