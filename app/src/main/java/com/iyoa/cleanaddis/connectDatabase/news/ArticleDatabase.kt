package com.iyoa.cleanaddis.connectDatabase.news

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.common.Media
import com.iyoa.cleanaddis.data.news.*


@Database(entities = arrayOf(Article:: class),version=1)
abstract class ArticleDatabase: RoomDatabase() {
    abstract fun articleDao(): ArticleDAO

    companion object{
        @Volatile
        private var INSTANCE: ArticleDatabase?=null

        fun getArticleDatabase(context: Context):ArticleDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,"article"
                ).build()
                INSTANCE=instance
                return instance
            }
        }


    }
}
