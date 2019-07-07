package com.iyoa.cleanaddis.data.news
//import androidx.room.*
//import com.iyoa.cleanaddis.entity.new.ArticleViewModel
import androidx.lifecycle.LiveData
import androidx.room.*
import com.iyoa.cleanaddis.data.common.Category
import java.util.*

@Dao
interface CategoryDAO {



    @Query("SELECT * FROM category WHERE uuid =:uuid")
    fun getCategoryByUuid(uuid: String): Category

    @Query("SELECT * FROM category WHERE name =:name")
    fun getCategoryByName(name: String): Category

    @Query("SELECT * FROM category")
    fun getAllCategory(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(news: Category)

    @Update
    fun updateCategory(news: Category)

    @Delete
    fun deleteCategory(news: Category)


}


