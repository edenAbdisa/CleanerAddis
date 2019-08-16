package com.iyoa.cleanaddis.connectDatabase.posting

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.posting.CommentDAO
import com.iyoa.cleanaddis.data.posting.CommentUUID
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(CommentUUID:: class ),version=1)
@TypeConverters(DataConverter::class)
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
