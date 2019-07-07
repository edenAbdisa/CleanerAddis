package com.iyoa.cleanaddis.data.news
//import androidx.room.*
//import com.iyoa.cleanaddis.entity.new.ArticleViewModel
import androidx.lifecycle.LiveData
import androidx.room.*
import com.iyoa.cleanaddis.data.common.MediaUUID

@Dao
interface MediaDAO {

    @Query("SELECT * FROM media WHERE uuid =:uuid")
    fun getMediaByUuid(uuid: String): MediaUUID


    @Query("SELECT * FROM media")
    fun getAllMedias(): LiveData<List<MediaUUID>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedia(mediaUUID: MediaUUID)

    @Update
    fun updateMedia(mediaUUID: MediaUUID)

    @Delete
    fun deleteMedia(mediaUUID: MediaUUID)


}


