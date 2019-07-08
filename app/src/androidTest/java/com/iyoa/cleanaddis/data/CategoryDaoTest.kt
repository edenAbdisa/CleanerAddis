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

package com.google.samples.apps.sunflower.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.iyoa.cleanaddis.connectDatabase.news.ArticleDatabase
import com.iyoa.cleanaddis.connectDatabase.news.CategoryDatabase
import com.iyoa.cleanaddis.data.common.Category
import com.iyoa.cleanaddis.data.news.Article
import com.iyoa.cleanaddis.data.news.ArticleDAO
import com.iyoa.cleanaddis.data.news.CategoryDAO
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
class CategoryDaoTest {

    private lateinit var database: CategoryDatabase
    val sdf = SimpleDateFormat("yy-mm-dd")
    private lateinit var categoryDao: CategoryDAO
    private val categoryA = Category("e9e847af-a680-4704-8d6b-840106aad78d".toLong(), "delilah",
        "Report"
       )


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()



    @Before fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, CategoryDatabase::class.java).build()
        categoryDao = database.categoryDao()

        categoryDao.insertCategory(categoryA)
    }

    @After fun closeDb() {

        database.close()
    }





    @Test fun testGetArticle() {
        assertThat(getValue(categoryDao.getCategoryByUuid(categoryA.uuid)), equalTo(categoryA))
    }

}