package com.iyoa.cleanaddis.data.posting

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PostDAO {
    @Query("SELECT * FROM post WHERE uuid =:uuid")
    fun getPostByUUID(uuid: String): LiveData<PostUUID>

    @Query("SELECT * FROM post")
    fun getAllPost(): LiveData<List<PostUUID>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(postUUID: PostUUID)

    @Update
    fun updatePost(postUUID: PostUUID)

    @Delete
    fun deletePost(postUUID: PostUUID)

    @Query("DELETE FROM post")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPost(listOfPostUUID: List<PostUUID>)
}