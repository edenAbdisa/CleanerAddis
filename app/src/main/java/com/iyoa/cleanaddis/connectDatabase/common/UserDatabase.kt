package com.iyoa.cleanaddis.connectDatabase.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.user.User
import com.iyoa.cleanaddis.data.user.UserDAO
import com.iyoa.cleanaddis.utility.DataConverter

@Database(entities = arrayOf(User:: class),version=1)
@TypeConverters(DataConverter::class)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDAO

    companion object{
        @Volatile
        private var INSTANCE: UserDatabase?=null

        fun getUserDatabase(context: Context):UserDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,"user_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }


    }
}