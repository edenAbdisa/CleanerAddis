package com.iyoa.cleanaddis.entity.posting

enum class FriendRequestStatus{
    REQUESTED,ACCEPTED,REMOVED
}
data class Friend(val uuid:Long,
                   val status:Enum<FriendRequestStatus>,
                   val username_requestor:String,
                   val username_acceptor:String) {
}