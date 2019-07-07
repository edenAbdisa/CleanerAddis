package com.iyoa.cleanaddis.connectDatabase.posting

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iyoa.cleanaddis.data.posting.LabelDAO
import com.iyoa.cleanaddis.data.posting.LabelUUID

@Database(entities = arrayOf(LabelUUID:: class ),version=1)
abstract class LabelDatabase: RoomDatabase() {
    abstract fun labelDao(): LabelDAO
    companion object{
        @Volatile
        private var INSTANCE: LabelDatabase?=null

        fun getLabelDatabase(context: Context):LabelDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    LabelDatabase::class.java,"label_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}
