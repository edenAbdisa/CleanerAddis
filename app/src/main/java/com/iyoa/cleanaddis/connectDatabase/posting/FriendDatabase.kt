package com.iyoa.cleanaddis.connectDatabase.posting

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.posting.FriendDAO
import com.iyoa.cleanaddis.data.posting.FriendUUID
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(FriendUUID:: class ),version=1)
@TypeConverters(DataConverter::class)
abstract class FriendDatabase: RoomDatabase() {
    abstract fun friendDao(): FriendDAO
    companion object{
        @Volatile
        private var INSTANCE: FriendDatabase?=null

        fun getFriendDatabase(context: Context):FriendDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
               val instance= Room.databaseBuilder(
                    context.applicationContext,
                    FriendDatabase::class.java,"friend_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}
