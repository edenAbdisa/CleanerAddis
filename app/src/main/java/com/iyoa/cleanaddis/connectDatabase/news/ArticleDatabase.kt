package com.iyoa.cleanaddis.connectDatabase.news

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO


@Database(entities = arrayOf(Article:: class ),version=1)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun newsDao(): ArticleDAO
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
