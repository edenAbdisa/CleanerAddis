package com.iyoa.cleanaddis.connectDatabase.posting

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iyoa.cleanaddis.data.posting.PostDAO
import com.iyoa.cleanaddis.entity.posting.Post


@Database(entities = arrayOf(Post:: class ),version=1)
abstract class PostDatabase: RoomDatabase() {
    abstract fun postDao(): PostDAO
    companion object{
        @Volatile
        private var INSTANCE: PostDatabase?=null

        fun getPostDatabase(context: Context):PostDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
               val instance= Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,"post_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}
