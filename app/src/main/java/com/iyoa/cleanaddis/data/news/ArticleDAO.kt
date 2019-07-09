package com.iyoa.cleanaddis.data.news
//import androidx.room.*
//import com.iyoa.cleanaddis.entity.new.ArticleViewModel
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDAO {



    @Query("SELECT * FROM Article WHERE uuid =:uuid")
    fun getNewsByUuid(uuid: String): LiveData<Article>


    @Query("SELECT * FROM Article")
    fun getAllNews(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article:Article)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addArticles(listOfArticles: List<Article>)




}


