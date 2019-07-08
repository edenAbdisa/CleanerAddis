package com.iyoa.cleanaddis.connectDatabase.news

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
<<<<<<< HEAD
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.data.news.*
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(Article:: class),version=1)
@TypeConverters(DataConverter::class)
=======
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO


//@Database(entities = arrayOf(Article:: class ),version=1)
>>>>>>> parent of 77bccfc... Article feature modified
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun articleDao(): ArticleDAO
    companion object{
        @Volatile
        private var INSTANCE: ArticleDatabase?=null

        fun getDatabase(context: Context):ArticleDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,"article_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}
