package com.iyoa.cleanaddis.connectDatabase.posting

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.posting.PostDAO
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.utility.CommentListConvertor
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(PostUUID:: class ),version=1)
@TypeConverters(CommentListConvertor::class)
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
