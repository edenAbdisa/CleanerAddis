package com.iyoa.cleanaddis.connectDatabase.teaching

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.connectDatabase.news.CategoryDatabase
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.news.CategoryDAO
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(Category:: class),version=1)
@TypeConverters(DataConverter::class)
abstract class TeachingDatabase:RoomDatabase() {
    abstract fun categoryDao(): CategoryDAO


    companion object{
        @Volatile
        private var INSTANCE: CategoryDatabase?=null

        fun getArticleDatabase(context: Context):CategoryDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    CategoryDatabase::class.java,"category"
                ).build()
                INSTANCE=instance
                return instance
            }
        }


    }




}