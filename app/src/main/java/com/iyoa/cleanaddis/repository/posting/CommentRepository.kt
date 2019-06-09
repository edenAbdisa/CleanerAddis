package com.iyoa.cleanaddis.repository.posting

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.CommentDAO
import com.iyoa.cleanaddis.data.posting.PostDAO
import com.iyoa.cleanaddis.entity.posting.Comment
import com.iyoa.cleanaddis.entity.posting.Post
import java.util.*

class CommentRepository(private val commentDAO: CommentDAO) {
    fun getAllComment():LiveData<List<Comment>> = commentDAO.getAllComment()

    fun insertComment(comment : Comment){
        commentDAO.insertComment(comment)
    }

    fun updateComment(comment:Comment){
        commentDAO.updateComment(comment)
    }
    fun getCommentByUUID(uuid:Long){
        commentDAO.getCommentByUUID(uuid)
    }
    fun deleteComment(comment:Comment){
        commentDAO.deleteComment(comment)
    }
    fun deleteAll(){
        commentDAO.deleteAll()
    }
    fun addComments(comments:List<Comment>){
        commentDAO.addComments(comments)
    }

}