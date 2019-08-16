package com.iyoa.cleanaddis.data.posting

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CommentDAO {
    @Query("SELECT * FROM comment WHERE uuid =:uuid")
    fun getCommentByUUID(uuid: String): LiveData<CommentUUID>

    @Query("SELECT * FROM comment")
    fun getAllComment(): LiveData<List<CommentUUID>>

    @Query("SELECT * FROM comment WHERE postUuid=:uuidPost")
    fun getAllCommentOfPost(uuidPost:String): LiveData<List<CommentUUID>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(commentUUID: CommentUUID)

    @Update
    fun updateComment(commentUUID: CommentUUID)

    @Delete
    fun deleteComment(commentUUID: CommentUUID)

    @Query("DELETE FROM comment")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addComments(listOfCommentUUID: List<CommentUUID>)
}