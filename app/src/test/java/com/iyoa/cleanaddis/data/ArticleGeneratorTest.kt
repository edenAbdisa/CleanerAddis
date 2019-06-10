<<<<<<< HEAD:app/src/test/java/com/iyoa/cleanaddis/unitTesting/ArticleGeneratorTest.kt
package com.iyoa.cleanaddis.unitTesting
=======
package com.iyoa.cleanaddis.data
>>>>>>> d15ee77371c217ef589293e91e5f9727430203d7:app/src/test/java/com/iyoa/cleanaddis/data/ArticleGeneratorTest.kt

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

        //val expectedArticle = ArticleData(title,media_uuid,text,published_date
        //,view_count,category_uuid)

        //assertEquals(expectedArticle,ArticleTest.generateArticle(
            //title,media_uuid,text,published_date
            //,view_count,category_uuid
        //))
    }
}