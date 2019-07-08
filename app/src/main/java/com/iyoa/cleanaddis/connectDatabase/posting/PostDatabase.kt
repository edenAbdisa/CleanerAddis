package com.iyoa.cleanaddis.connectDatabase.posting

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.posting.CommentDAO
import com.iyoa.cleanaddis.data.posting.FriendDAO
import com.iyoa.cleanaddis.data.posting.PostDAO
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Friend
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(Post:: class, Friend:: class, Comment:: class ),version=1)
@TypeConverters(DataConverter::class)
abstract class PostDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDAO
    abstract fun friendDao(): FriendDAO
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
        fun getCommentDatabase(context: Context):PostDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    PostDatabase::class.java,"comment_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}
