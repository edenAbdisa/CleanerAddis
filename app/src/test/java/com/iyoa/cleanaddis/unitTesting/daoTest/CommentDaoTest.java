package com.iyoa.cleanaddis.unitTesting.daoTest;


import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.iyoa.cleanaddis.connectDatabase.posting.PostDatabase;
import com.iyoa.cleanaddis.entity.posting.PostTest;
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
public class CommentDaoTest {

    private lateinit var database: PostDatabase
    private lateinit var postTest: PostTest

    @Before
    fun initDb() {
        postTest = PostTest()
        database =
                Room.databaseBuilder(
                        ApplicationProvider.getApplicationContext(),
                        PostDatabase::class.java,
                "comment"
            ).allowMainThreadQueries().build()


    }

    @After
    fun closeDb() = database.close()


    @Test
    fun insertComment(){
        val createdComment = Comment("h3j23h", "this is my comment", "p2o3s7ti8d","POSTED",3,"co3mm3n4ter",Date(2018))
        database.commentDao().insertComment(createdComment)
        val commentLoaded= database.commentDao().getCommentByUUID( "h3j23h")
        MatcherAssert.assertThat(commentLoaded.text, CoreMatchers.`is`(createdComment.text))
        MatcherAssert.assertThat(commentLoaded.postUuid, CoreMatchers.`is`(createdComment.postUuid))
        MatcherAssert.assertThat(commentLoaded.status, CoreMatchers.`is`(createdComment.status))
        MatcherAssert.assertThat(commentLoaded.noLike, CoreMatchers.`is`(createdComment.noLike))
        MatcherAssert.assertThat(commentLoaded.commentorUuid, CoreMatchers.`is`(createdComment.commentorUuid))
        MatcherAssert.assertThat(commentLoaded.date, CoreMatchers.`is`(createdComment.date))
    }
}
