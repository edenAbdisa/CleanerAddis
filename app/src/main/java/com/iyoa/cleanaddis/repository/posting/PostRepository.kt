package com.iyoa.cleanaddis.repository.posting

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.PostDAO
import com.iyoa.cleanaddis.data.posting.PostUUID

class PostRepository(private val postDAO: PostDAO) {
    fun getAllPost():LiveData<List<PostUUID>> = postDAO.getAllPost()

    fun insertPost(postUUID :PostUUID){
        postDAO.insertPost(postUUID)
    }

    fun updatePost(postUUID:PostUUID){
        postDAO.updatePost(postUUID)
    }
    fun getPostByUUID(uuid:String){
        postDAO.getPostByUUID(uuid)
    }
    fun deletePost(postUUID:PostUUID){
        postDAO.deletePost(postUUID)
    }
    fun deleteAll(){
        postDAO.deleteAll()
    }
    fun addPosts(postUUIDS:List<PostUUID>){
        postDAO.addPost(postUUIDS)
    }

}