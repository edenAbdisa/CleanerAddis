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

package com.google.samples.apps.sunflower.viewmodels

import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry

import com.iyoa.cleanaddis.connectDatabase.news.ArticleDatabase
import com.iyoa.cleanaddis.data.news.ArticleDAO
import com.iyoa.cleanaddis.repository.news.ArticleRepository
import com.iyoa.cleanaddis.viewModels.news.ArticleViewModel
import io.reactivex.internal.util.NotificationLite.getValue
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArticleViewModelTest {

    private lateinit var appDatabase: ArticleDatabase
    private lateinit var viewModel: ArticleViewModel
    private lateinit var articleDao:ArticleDAO

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, ArticleDatabase::class.java).build()
        articleDao = appDatabase.articleDao()
        val articleRepo = ArticleRepository(articleDao)

        viewModel = ArticleViewModel(context as Application)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() {
        assertFalse(getValue(viewModel.allArticles))
    }
}