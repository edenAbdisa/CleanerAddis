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
import com.iyoa.cleanaddis.retrofitEden.FriendServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FriendViewModel(application: Application): AndroidViewModel(application)  {
    private val friendRepos: FriendRepository
    private val friendServiceImpl: FriendServiceImpl

    init{
        val  commentDAO = FriendDatabase.getFriendDatabase(application).friendDao()
        friendRepos =FriendRepository(commentDAO)
        friendServiceImpl=FriendServiceImpl()
    }


}