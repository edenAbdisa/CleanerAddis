package com.iyoa.cleanaddis.connectDatabase.report

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iyoa.cleanaddis.data.report.ReportDAO

abstract class ReportDatabase : RoomDatabase() {
    abstract fun reportDao() : ReportDAO


    companion object{
        @Volatile
        private var INSTANCE: ReportDatabase?=null

        fun getDatabase(context: Context):ReportDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    ReportDatabase::class.java,"article_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }



}