package com.iyoa.cleanaddis.data.posting

import androidx.room.*
import com.iyoa.cleanaddis.entity.posting.Post
import java.util.*

@Dao
interface PostDAO {
    @Query("SELECT * FROM post WHERE uuid =:uuid")
    fun getPostByUUID(uuid: Long): Post

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)

    @Update
    fun updatePost(post: Post)

    @Delete
    fun deletePost(post: Post)

    @Query("DELETE FROM post")
    fun deleteAll()
}