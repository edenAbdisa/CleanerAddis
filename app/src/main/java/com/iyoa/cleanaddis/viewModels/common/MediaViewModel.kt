package com.iyoa.cleanaddis.viewModels.news

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.iyoa.cleanaddis.connectDatabase.news.MediaDatabase
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.repository.common.CategoryRepos
import com.iyoa.cleanaddis.repository.common.MediaRepos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MediaViewModel(application: Application):AndroidViewModel(application) {
    private val mediaRepos: MediaRepos
    val allMedias : LiveData<List<Media>>


    init{
        val  mediaDao = MediaDatabase.getMediaDatabase(application).mediaDao()
        mediaRepos = MediaRepos(mediaDao)
        allMedias = mediaRepos.allMedias()
    }


    fun insertMedia(media:Media) = viewModelScope.launch(Dispatchers.IO)
    {
        mediaRepos.insertMedia(media)
    }

}