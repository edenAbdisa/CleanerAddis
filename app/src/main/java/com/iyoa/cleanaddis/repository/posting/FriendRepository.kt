package com.iyoa.cleanaddis.repository.posting

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.FriendDAO
import com.iyoa.cleanaddis.entity.posting.Friend


class FriendRepository(private val friendDAO: FriendDAO) {
    fun getAllFriend():LiveData<List<Friend>> = friendDAO.getAllFriend()

    fun insertFriend(friend :Friend){
        friendDAO.insertFriend(friend)
    }

    fun updateFriend(friend:Friend){
        friendDAO.updateFriend(friend)
    }
    fun getFriendByUUID(uuid:String){
        friendDAO.getFriendByUUID(uuid)
    }
    fun deleteFriend(friend:Friend){
        friendDAO.deleteFriend(friend)
    }
    fun deleteAll(){
        friendDAO.deleteAll()
    }
    fun addFriends(friends:List<Friend>){
        friendDAO.addFriends(friends)
    }

}