package com.iyoa.cleanaddis.connectDatabase.news

/*
@Database(entities = arrayOf(News:: class ),version=1)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao():NewsDAO
    companion object{
        @Volatile
        private var INSTANCE: NewsDatabase?=null

        fun getDatabase(context: Context):NewsDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,"news_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }
}
        */