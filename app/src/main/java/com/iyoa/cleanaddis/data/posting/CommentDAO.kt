package com.iyoa.cleanaddis.data.posting

import androidx.lifecycle.LiveData
import androidx.room.*
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post
import java.util.*

@Dao
interface CommentDAO {
    @Query("SELECT * FROM comment WHERE uuid =:uuid")
    fun getCommentByUUID(uuid: String): LiveData<Comment>

    @Query("SELECT * FROM comment")
    fun getAllComment(): LiveData<List<Comment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: Comment)

    @Update
    fun updateComment(comment: Comment)

    @Delete
    fun deleteComment(comment: Comment)

    @Query("DELETE FROM comment")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addComments(listOfComment: List<Comment>)
}