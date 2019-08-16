package com.iyoa.cleanaddis.unitTesting.daoTest;


import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import com.iyoa.cleanaddis.connectDatabase.posting.PostDatabase;
import com.iyoa.cleanaddis.entity.posting.PostTest;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

//import kotlinx.coroutines.test.runBlockingTest

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
public class PostDaoTest {

    private lateinit var database: PostDatabase
    private lateinit var postTest: PostTest

    @Before
    fun initDb() {
        postTest = PostTest()
        database =
                Room.databaseBuilder(
                        ApplicationProvider.getApplicationContext(),
                        PostDatabase::class.java,
                "post"
            ).allowMainThreadQueries().build()


    }

    @After
    fun closeDb() = database.close()


    @Test
    fun insertPost(){
        val createdPost = Post("h3j23hpost", "edenAb", 7,7,1,1,"co3mm3n4ter","co3media34ter","ALL","POSTED",Date(2019))
        database.commentDao().insertComment(comment)

        val loadedPost= database.commentDao().getPostByUUID( "h3j23hpost")

        MatcherAssert.assertThat(loadedPost.username, CoreMatchers.`is`(createdPost.username))
        MatcherAssert.assertThat(loadedPost.noLike, CoreMatchers.`is`(createdPost.noLike))
        MatcherAssert.assertThat(loadedPost.noView, CoreMatchers.`is`(createdPost.noView))
        MatcherAssert.assertThat(loadedPost.downloadable, CoreMatchers.`is`(createdPost.downloadable))
        MatcherAssert.assertThat(loadedPost.allowToBeUsedForArticle, CoreMatchers.`is`(createdPost.allowToBeUsedForArticle))
        MatcherAssert.assertThat(loadedPost.mediaUuid, CoreMatchers.`is`(createdPost.mediaUuid))
        MatcherAssert.assertThat(loadedPost.categoryUuid, CoreMatchers.`is`(createdPost.categoryUuid))
        MatcherAssert.assertThat(loadedPost.can_be_viewed_by, CoreMatchers.`is`(createdPost.can_be_viewed_by))
        MatcherAssert.assertThat(loadedPost.status, CoreMatchers.`is`(createdPost.status))
        MatcherAssert.assertThat(loadedPost.date, CoreMatchers.`is`(createdPost.date))
    }
}
