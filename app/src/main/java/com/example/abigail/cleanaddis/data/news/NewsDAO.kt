package com.example.abigail.cleanaddis.data.news
import androidx.room.*
import com.example.abigail.cleanaddis.entity.new.News
import java.util.*

@Dao
interface NewsDAO {
    @Query("SELECT * FROM news WHERE news_uuid =:uuid")
    fun getNewsByCode(uuid: UUID): News

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: News)

    @Update
    fun updateNews(news: News)

    @Delete
    fun deleteNews(news: News)

    @Query("DELETE FROM news")
    fun deleteAll()
}

