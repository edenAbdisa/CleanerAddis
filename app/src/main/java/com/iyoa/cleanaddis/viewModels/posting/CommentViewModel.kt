package com.iyoa.cleanaddis.viewModels.posting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.posting.PostDatabase
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.repository.posting.CommentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentViewModel(application: Application): AndroidViewModel(application)  {
    private val commentRepos: CommentRepository
    val comment : LiveData<List<Comment>>
    val liveItem: LiveItem = LiveItem()
    init{
        val  commentDAO = PostDatabase.getCommentDatabase(application).commentDao()
        commentRepos = CommentRepository(commentDAO)
        comment = commentRepos.getAllComment()
    }
    fun insertComment(comment:Comment) = viewModelScope.launch(Dispatchers.IO)
    {
        commentRepos.insertComment(comment)
    }
    fun getComment() = viewModelScope.launch(Dispatchers.IO) {
        commentRepos.getAllComment()
    }
    fun addComments(comments:List<Comment>) = viewModelScope.launch(Dispatchers.IO) {
        commentRepos.addComments(comments)
    }
    inner class LiveItem {
        val comment = MutableLiveData<Comment>()
    }
}