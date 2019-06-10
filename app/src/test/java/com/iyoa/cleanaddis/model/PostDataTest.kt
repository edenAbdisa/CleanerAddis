package com.iyoa.cleanaddis.model

import com.iyoa.cleanaddis.data.news.ArticleData
import com.iyoa.cleanaddis.entity.new.ArticleEntity
import com.iyoa.cleanaddis.entity.posting.Post
import com.iyoa.cleanaddis.entity.posting.PostTest
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class PostDataTest {
    private lateinit var postTest: PostTest

    @Before
    fun setup(){

        postTest = PostTest()
    }

    @Test
    fun testAddPost(){

        val  uuid="jkjkj43"
        val username="Eden"
        val noLike=5
        val noView=6
        val downloadable=1
        val allowToBeUsedForArticle=1
        val mediaUuid="jkjkj43jk"
        val categoryUuid= "jkjkj43cat"
        val can_be_viewed_by="ALL"
        val status="POSTED"
        val date= Date(2018)


        val expectedPost = Post(uuid,username,noLike,noView
            ,allowToBeUsedForArticle,downloadable,mediaUuid,categoryUuid,can_be_viewed_by,status,date)

        Assert.assertEquals(
            expectedPost, postTest.generatePost(
                uuid,username,noLike,noView
                ,allowToBeUsedForArticle,downloadable,mediaUuid,categoryUuid,can_be_viewed_by,status,date
            )
        )
    }
}