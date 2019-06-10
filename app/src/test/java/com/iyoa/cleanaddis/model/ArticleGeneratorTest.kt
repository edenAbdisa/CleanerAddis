package com.iyoa.cleanaddis.model

import com.iyoa.cleanaddis.data.news.ArticleData
import com.iyoa.cleanaddis.entity.new.ArticleEntity
import org.junit.Before
import org.junit.Test
import junit.framework.Assert.assertEquals
import java.util.*

class ArticleDataTest {
    private lateinit var ArticleTest: ArticleEntity

    @Before
    fun setup(){

        ArticleTest = ArticleEntity()
    }

    @Test
    fun testAddArticle(){
        val title="Delilah"
        val media_uuid=UUID.randomUUID()

        val text="Hey there"
        val published_date= Date(2018)
        val view_count=5
        val category_uuid= UUID.randomUUID()

        val expectedArticle = ArticleData(title,media_uuid,text,published_date
        ,view_count,category_uuid)

        assertEquals(expectedArticle,ArticleTest.generateArticle(
            title,media_uuid,text,published_date
            ,view_count,category_uuid
        ))
    }
}