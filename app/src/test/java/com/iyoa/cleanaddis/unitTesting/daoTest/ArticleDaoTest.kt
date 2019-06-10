/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.iyoa.cleanaddis.unitTesting.daoTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.iyoa.cleanaddis.connectDatabase.news.ArticleDatabase
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO
import io.reactivex.internal.util.NotificationLite.getValue
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.text.SimpleDateFormat

@RunWith(AndroidJUnit4::class)
class ArticleDaoTestTest {

    private lateinit var database: ArticleDatabase
    val sdf = SimpleDateFormat("yy-mm-dd")
    private lateinit var articleDao: ArticleDAO
    private val articleA = Article("e9e847af-a680-4704-8d6b-840106aad78d".toLong(), "delilah", "c2545c58-3352-4986-94ee-68c64b6e935e".toLong(), "post",
        sdf.parse("2019-11-10"),0,"b7d68bed-bb4c-4e71-bad5-f0a0e28c9c79".toLong())


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()



    @Before fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, ArticleDatabase::class.java).build()
        articleDao = database.articleDao()

        articleDao.insertArticle(articleA)
    }

    @After fun closeDb() {

        database.close()
    }





    @Test fun testGetArticle() {
        assertThat(getValue(articleDao.getNewsByUuid(articleA.uuid)), equalTo(articleA))
    }

}