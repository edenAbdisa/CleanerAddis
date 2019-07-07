package com.iyoa.cleanaddis.repository.posting

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.CommentDAO
import com.iyoa.cleanaddis.data.posting.CommentUUID

class CommentRepository(private val commentDAO: CommentDAO) {
    fun getAllComment():LiveData<List<CommentUUID>> = commentDAO.getAllComment()

    fun getAllCommentOfPost(postUUID:String):LiveData<List<CommentUUID>> = commentDAO.getAllCommentOfPost(postUUID)

    fun insertComment(commentUUID : CommentUUID){
        commentDAO.insertComment(commentUUID)
    }

    fun updateComment(commentUUID:CommentUUID){
        commentDAO.updateComment(commentUUID)
    }
    fun getCommentByUUID(uuid:String){
        commentDAO.getCommentByUUID(uuid)
    }
    fun deleteComment(commentUUID:CommentUUID){
        commentDAO.deleteComment(commentUUID)
    }
    fun deleteAll(){
        commentDAO.deleteAll()
    }
    fun addComments(commentUUIDS:List<CommentUUID>){
        commentDAO.addComments(commentUUIDS)
    }

}