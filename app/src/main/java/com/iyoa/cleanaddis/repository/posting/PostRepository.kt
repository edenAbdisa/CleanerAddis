package com.iyoa.cleanaddis.repository.posting

import androidx.lifecycle.LiveData
import com.iyoa.cleanaddis.data.posting.PostDAO
import com.iyoa.cleanaddis.entity.posting.Post
import java.util.*

class PostRepository(private val postDAO: PostDAO) {
    fun getAllPost():LiveData<List<Post>> = postDAO.getAllPost()

    fun insertPost(post :Post){
        postDAO.insertPost(post)
    }

    fun updatePost(post:Post){
        postDAO.updatePost(post)
    }
    fun getPostByUUID(uuid:Long){
        postDAO.getPostByUUID(uuid)
    }
    fun deletePost(post:Post){
        postDAO.deletePost(post)
    }
    fun deleteAll(){
        postDAO.deleteAll()
    }
    fun addPosts(posts:List<Post>){
        postDAO.addPost(posts)
    }

}