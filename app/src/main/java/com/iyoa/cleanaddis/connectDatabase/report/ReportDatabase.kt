package com.iyoa.cleanaddis.connectDatabase.news

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iyoa.cleanaddis.data.news.*
import com.iyoa.cleanaddis.data.report.Report
import com.iyoa.cleanaddis.data.report.ReportDAO
import com.iyoa.cleanaddis.utility.DataConverter


@Database(entities = arrayOf(Report::class),version=1)
@TypeConverters(DataConverter::class)
abstract class ReportDatabase: RoomDatabase() {
    abstract fun reportDao(): ReportDAO

    companion object{
        @Volatile
        private var INSTANCE: ReportDatabase?=null

        fun getReportDatabase(context: Context):ReportDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    ReportDatabase::class.java,"report"
                ).build()
                INSTANCE=instance
                return instance
            }
        }


    }
}
