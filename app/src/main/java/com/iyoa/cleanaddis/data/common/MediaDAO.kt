package com.iyoa.cleanaddis.data.news
//import androidx.room.*
//import com.iyoa.cleanaddis.entity.new.ArticleViewModel
import androidx.lifecycle.LiveData
import androidx.room.*
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.common.Media
import java.util.*

@Dao
interface MediaDAO {



    @Query("SELECT * FROM Media WHERE uuid =:uuid")
    fun getMediaByUuid(uuid: Long): Media


    @Query("SELECT * FROM Media")
    fun getAllMedias(): LiveData<List<Media>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedia(news: Media)

    @Update
    fun updateMedia(news: Media)

    @Delete
    fun deleteMedia(news: Media)


}


