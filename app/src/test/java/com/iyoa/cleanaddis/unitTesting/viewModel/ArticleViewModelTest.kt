
package com.iyoa.cleanaddis.unitTesting.viewModel

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