package com.iyoa.cleanaddis.unitTesting.viewModel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.MediumTest;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.runBlocking;
import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.runner.RunWith;

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@MediumTest
public class PostViewModelTest {
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
        val createdPost = Post("h3j23hpost", "edenAb", 7,7,1,1,"co3mm3n4ter","co3media34ter","ALL","POSTED",Date(2019))
        repo.insertPost(createdPost)

        val result  = repo.getPostByUUID("h3j23hpost")

        Assert.assertThat(result, CoreMatchers.notNullValue())
    }

}
