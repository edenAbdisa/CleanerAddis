package com.iyoa.cleanaddis.connectDatabase.posting

/*
@Database(entities = arrayOf(ArticleViewModel:: class ),version=1)
abstract class PostDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDAO
    companion object{
        @Volatile
        private var INSTANCE: PostDatabase?=null

        fun getDatabase(context: Context):PostDatabase{
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

    }
}
        */