package com.iyoa.cleanaddis.repository.common

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.data.news.MediaDAO

class MediaRepos(val mediaDAO: MediaDAO) {
    fun allMedias(): LiveData<List<Media>> = mediaDAO.getAllMedias()

    fun insertMedia(media: Media){
        mediaDAO.insertMedia(media)
    }
}