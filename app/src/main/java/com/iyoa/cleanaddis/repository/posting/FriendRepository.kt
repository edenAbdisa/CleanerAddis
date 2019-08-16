package com.iyoa.cleanaddis.repository.posting

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.FriendDAO
import com.iyoa.cleanaddis.data.posting.FriendUUID


class FriendRepository(private val friendDAO: FriendDAO) {
    fun getAllFriend():LiveData<List<FriendUUID>> = friendDAO.getAllFriend()

    fun insertFriend(friendUUID :FriendUUID){
        friendDAO.insertFriend(friendUUID)
    }

    fun updateFriend(friendUUID:FriendUUID){
        friendDAO.updateFriend(friendUUID)
    }
    fun getFriendByUUID(uuid:String){
        friendDAO.getFriendByUUID(uuid)
    }
    fun deleteFriend(friendUUID:FriendUUID){
        friendDAO.deleteFriend(friendUUID)
    }
    fun deleteAll(){
        friendDAO.deleteAll()
    }
    fun addFriends(friendUUIDS:List<FriendUUID>){
        friendDAO.addFriends(friendUUIDS)
    }

}