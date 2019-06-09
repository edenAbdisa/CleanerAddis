package com.iyoa.cleanaddis.connectDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.connectDatabase.news.ArticleDatabase
import com.iyoa.cleanaddis.data.common.Address
import com.iyoa.cleanaddis.data.common.AddressDAO
import com.iyoa.cleanaddis.data.news.ArticleDAO
import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.data.report.ReportDAO
import com.iyoa.cleanaddis.utility.DataConverter

@Database(entities = arrayOf(Report:: class, Address::class),version=1)
@TypeConverters(DataConverter::class)
abstract class DatabaseHelper: RoomDatabase()  {

    abstract fun reportDAO(): ReportDAO
    abstract fun addressDao(): AddressDAO
    companion object{
        @Volatile
        private var INSTANCE: DatabaseHelper?=null

        fun getDatabase(context: Context,name:String): DatabaseHelper {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseHelper::class.java,name
                ).build()
                INSTANCE=instance
                return instance
            }
        }


    }



}