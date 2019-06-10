package com.iyoa.cleanaddis.unitTesting.viewModel;
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.*
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest
public class CommentViewModelTest {
    private lateinit var repo: CommentRepository
    private lateinit var database: PostDatabase

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        database = Room.databaseBuilder(
                ApplicationProvider.getApplicationContext(),
                PostDatabase::class.java,
                "comment").allowMainThreadQueries().build()

        repo = CommentRepository(database.commentDao())
    }
    @After
    fun cleanUp() {
        database.close()
    }
    @Test
    fun addAndRetrieveUsingRepo()= runBlocking{
        val createdComment = Comment("h3j23h", "this is my comment", "p2o3s7ti8d","POSTED",3,"co3mm3n4ter",Date(2018))
        repo.insertComment(createdComment)

        val result  = repo.getCommentByUUID("h3j23h")

        Assert.assertThat(result, CoreMatchers.notNullValue())
    }

}
