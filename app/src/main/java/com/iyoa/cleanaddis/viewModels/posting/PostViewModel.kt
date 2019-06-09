package com.iyoa.cleanaddis.viewModels.posting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.posting.PostDatabase
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.repository.posting.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(application: Application): AndroidViewModel(application)  {
    private val postRepos: PostRepository
    val allPost : LiveData<List<Post>>

    init{
        val  postDAO = PostDatabase.getPostDatabase(application).postDao()
        postRepos = PostRepository(postDAO)
        allPost = postRepos.getAllPost()
    }
    fun insertPost(post:Post) = viewModelScope.launch(Dispatchers.IO)
    {
        postRepos.insertPost(post)
    }
    fun getPosts() = viewModelScope.launch(Dispatchers.IO) {
        postRepos.getAllPost()
    }
    fun addPosts(posts:List<Post>) = viewModelScope.launch(Dispatchers.IO) {
       postRepos.addPosts(posts)
    }

}