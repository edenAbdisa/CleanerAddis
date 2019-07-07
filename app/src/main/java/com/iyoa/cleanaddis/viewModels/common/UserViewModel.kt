package com.iyoa.cleanaddis.viewModels.common

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.entity.user.User
import com.iyoa.cleanaddis.retrofitEden.UserServiceImpl
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel (application: Application): AndroidViewModel(application) {
   // private val userRepos: UserRRepos
    private val userServiceImpl: UserServiceImpl
    lateinit var user : ObservableField<User>

    init{
        user= ObservableField<User>()
       // val  mediaDao = MediaDatabase.getMediaDatabase(application).mediaDao()
      //  mediaRepos = MediaRepos(mediaDao)
        userServiceImpl= UserServiceImpl()
    }



    private val _getResponse = MutableLiveData<Response<User>>()
    val getResponse: LiveData<Response<User>>
        get() = _getResponse

    fun getUserByName(username: String) = viewModelScope.launch {
        _getResponse.postValue(userServiceImpl.getUserByName(username))
    }


}