package com.iyoa.cleanaddis.viewModels.posting

import android.app.Application
import android.content.Context
import android.os.Messenger
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.connectDatabase.posting.PostDatabase
import com.iyoa.cleanaddis.controller.account.SigninFragment
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.repository.posting.CommentRepository
import com.iyoa.cleanaddis.repository.posting.PostRepository
import com.iyoa.cleanaddis.retrofitEden.CommentServiceImpl
import com.iyoa.cleanaddis.retrofitEden.PostServiceImpl
import com.iyoa.cleanaddis.utility.DateUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.DateFormat
import java.time.LocalDateTime
import java.util.*

class PostViewModel(application: Application): AndroidViewModel(application)  {
    lateinit var app:Application
    private val postRepos: PostRepository
    private val commentServiceImpl: CommentServiceImpl
    private val postServiceImpl: PostServiceImpl
    lateinit var post : ObservableField<PostUUID>
    lateinit var user : ObservableField<User>
    init{
        post=ObservableField<PostUUID>()

        user=ObservableField<User>()
        val  postDAO = PostDatabase.getPostDatabase(application).postDao()
        postRepos = PostRepository(postDAO)
        postServiceImpl=PostServiceImpl()
        commentServiceImpl=CommentServiceImpl()
    }

    //values for databinding
    val editTextComment=MutableLiveData<String>()
    val textViewPostUUID=MutableLiveData<String>()

    //function called by the databinding layout updateLke
    fun updateLike()=updatePostLike(textViewPostUUID.toString())

    //function called when user enter the comment button
    fun insertCommentForPost()=insertComment(getComment())

    private val _getResponses = MutableLiveData<Response<List<PostUUID>>>()
    val getResponses: LiveData<Response<List<PostUUID>>>
        get() = _getResponses
    fun getPosts() = viewModelScope.launch{
        _getResponses.postValue(postServiceImpl.getPosts())
    }

    private val _insertResponse = MutableLiveData<Response<Post>>()
    val insertResponse: LiveData<Response<Post>>
        get() = _insertResponse
    fun insertPost(post: Post) = viewModelScope.launch {
        _insertResponse.postValue(postServiceImpl.insertPost(post))
    }

    private val _insertCommentResponse = MutableLiveData<Response<Comment>>()
    val insertCommentResponse: LiveData<Response<Comment>>
        get() = _insertCommentResponse
    fun insertComment(comment: Comment) = viewModelScope.launch {
        _insertCommentResponse.postValue(commentServiceImpl.insertComment(comment))
    }

    private val _updatePostLikeResponse = MutableLiveData<Response<Post>>()
    val updatePostLikeResponse: LiveData<Response<Post>>
        get() = _updatePostLikeResponse
    fun updatePostLike(postId:String) = viewModelScope.launch {
        _updatePostLikeResponse.postValue(postServiceImpl.increaseNumberOfLikeOfPost(postId))
    }
    fun getComment(): Comment {
        val signinFragment = SigninFragment()
        val text:String=editTextComment.toString()
        val postUuid:String=textViewPostUUID.toString()
        val status: String="POSTED"
        val noLike: Int=0
        val commenterUuid:String=signinFragment.getSavedUserUUID()
        val date: String = DateUtility.getCurrentDate()
        val newComment=Comment ( text,postUuid, status, noLike,commenterUuid,date)
        return newComment
    }

}