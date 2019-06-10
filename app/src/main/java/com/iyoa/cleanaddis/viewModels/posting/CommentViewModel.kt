package com.iyoa.cleanaddis.viewModels.posting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.posting.CommentDatabase
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.repository.posting.CommentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentViewModel(application: Application): AndroidViewModel(application)  {
    private val commentRepos: CommentRepository
    val allComment : LiveData<List<Comment>>
    val liveItem: LiveItem = LiveItem()
    init{
        val  commentDAO = CommentDatabase.getCommentDatabase(application).commentDao()
        commentRepos = CommentRepository(commentDAO)
        allComment = commentRepos.getAllComment()
    }
    fun insertComment(comment:Comment) = viewModelScope.launch(Dispatchers.IO)
    {
        commentRepos.insertComment(comment)
    }
    fun getComments() = viewModelScope.launch(Dispatchers.IO) {
        commentRepos.getAllComment()
    }
    fun addComments(comments:List<Comment>) = viewModelScope.launch(Dispatchers.IO) {
        commentRepos.addComments(comments)
    }
    inner class LiveItem {
        val comment = MutableLiveData<Comment>()
    }
}