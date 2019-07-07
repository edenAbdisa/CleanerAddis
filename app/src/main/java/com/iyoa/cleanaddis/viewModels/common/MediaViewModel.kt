package com.iyoa.cleanaddis.viewModels.common

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.MediaDatabase
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.entity.common.Media
import com.iyoa.cleanaddis.repository.common.CategoryRepos
import com.iyoa.cleanaddis.repository.common.MediaRepos
import com.iyoa.cleanaddis.retrofitEden.MediaServiceImpl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Multipart
import java.io.File

class MediaViewModel(application: Application):AndroidViewModel(application) {
    private val mediaRepos: MediaRepos
    private val mediaServiceImpl: MediaServiceImpl
    lateinit var media : ObservableField<MediaUUID>

    init{
        media=ObservableField<MediaUUID>()
        val  mediaDao = MediaDatabase.getMediaDatabase(application).mediaDao()
        mediaRepos = MediaRepos(mediaDao)
        mediaServiceImpl=MediaServiceImpl()
    }



    private val _insertMediaResponse = MutableLiveData<Response<MediaUUID>>()
    val insertMediaResponse: LiveData<Response<MediaUUID>>
        get() = _insertMediaResponse
    fun insertMedia(file: Multipart, media: Media) = viewModelScope.launch {
        _insertMediaResponse.postValue(mediaServiceImpl.insertMedia(file,media))
    }


}