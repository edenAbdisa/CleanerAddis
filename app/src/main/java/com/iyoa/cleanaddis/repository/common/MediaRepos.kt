package com.iyoa.cleanaddis.repository.common

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.data.news.MediaDAO

class MediaRepos(val mediaDAO: MediaDAO) {
    fun allMedias(): LiveData<List<MediaUUID>> = mediaDAO.getAllMedias()

    fun insertMedia(mediaUUID: MediaUUID){
        mediaDAO.insertMedia(mediaUUID)
    }
}