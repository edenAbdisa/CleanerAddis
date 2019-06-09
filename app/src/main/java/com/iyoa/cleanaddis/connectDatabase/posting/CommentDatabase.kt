package com.iyoa.cleanaddis.connectDatabase.posting

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iyoa.cleanaddis.data.posting.CommentDAO
import com.iyoa.cleanaddis.data.posting.PostDAO
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post


@Database(entities = arrayOf(Comment:: class ),version=1)
abstract class CommentDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDAO
    companion object{
        @Volatile
        private var INSTANCE: CommentDatabase?=null

        fun getCommentDatabase(context: Context):CommentDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
               val instance= Room.databaseBuilder(
                    context.applicationContext,
                    CommentDatabase::class.java,"comment_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}
