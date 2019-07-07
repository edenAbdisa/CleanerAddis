package com.iyoa.cleanaddis.connectDatabase.news

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.common.MediaUUID
import com.iyoa.cleanaddis.data.news.MediaDAO
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(MediaUUID:: class),version=1)
@TypeConverters(DataConverter::class)
abstract class MediaDatabase: RoomDatabase() {

    abstract fun mediaDao(): MediaDAO

    companion object{
        @Volatile
        private var INSTANCE: MediaDatabase?=null

        fun getMediaDatabase(context: Context):MediaDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    MediaDatabase::class.java,"media_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }


    }
}
