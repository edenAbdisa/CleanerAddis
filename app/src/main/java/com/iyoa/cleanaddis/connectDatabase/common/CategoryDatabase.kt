package com.iyoa.cleanaddis.connectDatabase.news

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO
import com.iyoa.cleanaddis.data.news.CategoryDAO
import com.iyoa.cleanaddis.data.news.MediaDAO
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(Category:: class),version=1)
@TypeConverters(DataConverter::class)
abstract class CategoryDatabase: RoomDatabase() {

    abstract fun categoryDao(): CategoryDAO
    companion object{
        @Volatile
        private var INSTANCE: CategoryDatabase?=null

        fun getCategoryDatabase(context: Context):CategoryDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    CategoryDatabase::class.java,"category_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }


    }
}
