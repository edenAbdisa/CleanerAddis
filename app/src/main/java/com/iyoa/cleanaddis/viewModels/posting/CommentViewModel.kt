package com.iyoa.cleanaddis.viewModels.posting

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.posting.CommentDatabase
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.repository.posting.CommentRepository
import com.iyoa.cleanaddis.retrofitEden.CommentServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class CommentViewModel(application: Application): AndroidViewModel(application)  {
    private val commentRepos: CommentRepository
    private val commentServiceImpl: CommentServiceImpl

    lateinit var comment : ObservableField<CommentUUID>
    init{
        comment=ObservableField<CommentUUID>()
        val  commentDAO = CommentDatabase.getCommentDatabase(application).commentDao()
        commentRepos = CommentRepository(commentDAO)
        commentServiceImpl=CommentServiceImpl()
    }

    private val _insertResponse = MutableLiveData<Response<Comment>>()
    val insertResponse: LiveData<Response<Comment>>
        get() = _insertResponse
    fun insertComment(comment: Comment) = viewModelScope.launch {
        _insertResponse.postValue(commentServiceImpl.insertComment(comment))
    }

    private val _getResponses = MutableLiveData<Response<List<CommentUUID>>>()
    val getResponses: LiveData<Response<List<CommentUUID>>>
        get() = _getResponses

    fun getCommentByPostId(id: String) = viewModelScope.launch{
        _getResponses.postValue(commentServiceImpl.getCommentByPostId(id))
    }
}