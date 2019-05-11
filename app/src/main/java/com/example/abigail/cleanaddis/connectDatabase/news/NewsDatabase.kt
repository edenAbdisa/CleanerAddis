package com.example.abigail.cleanaddis.connectDatabase.news

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.abigail.cleanaddis.data.news.NewsDAO
import com.example.abigail.cleanaddis.entity.new.News

@Database(entities = arrayOf(News:: class ),version=1)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao():NewsDAO
    companion object{
        @Volatile
        private var INSTANCE: NewsDatabase?=null

        fun getDatabase(context: Context):NewsDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,"news_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}