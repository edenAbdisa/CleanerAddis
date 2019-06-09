package com.iyoa.cleanaddis.viewModels.posting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.posting.FriendDatabase
import com.iyoa.cleanaddis.connectDatabase.posting.PostDatabase
import com.iyoa.cleanaddis.entity.posting.Friend
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.repository.posting.FriendRepository
import com.iyoa.cleanaddis.repository.posting.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FriendViewModel(application: Application): AndroidViewModel(application)  {
    private val friendRepos: FriendRepository
    val allFriend : LiveData<List<Friend>>

    init{
        val  friendDAO = FriendDatabase.getFriendDatabase(application).friendDao()
        friendRepos = FriendRepository(friendDAO)
        allFriend = friendRepos.getAllFriend()
    }
    fun insertFriend(friend:Friend) = viewModelScope.launch(Dispatchers.IO)
    {
        friendRepos.insertFriend(friend)
    }
    fun getFriends() = viewModelScope.launch(Dispatchers.IO) {
        friendRepos.getAllFriend()
    }
    fun addFriends(friends:List<Friend>) = viewModelScope.launch(Dispatchers.IO) {
        friendRepos.addFriends(friends)
    }

}