package com.iyoa.cleanaddis.data.news
//import androidx.room.*
//import com.iyoa.cleanaddis.entity.new.ArticleViewModel
import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface ArticleDAO {



    @Query("SELECT * FROM Article WHERE uuid =:uuid")
    fun getNewsByUuid(uuid: Long): Article


    @Query("SELECT * FROM Article")
    fun getAllNews(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: Article)

    @Update
    fun updateNews(news: Article)

    @Delete
    fun deleteNews(news: Article)


}


