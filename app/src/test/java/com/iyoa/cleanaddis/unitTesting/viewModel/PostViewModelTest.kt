package com.iyoa.cleanaddis.unitTesting.viewModel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.android.gms.tasks.Task
import com.iyoa.cleanaddis.viewModels.posting.PostViewModel;
import com.google.common.truth.Truth.assertThat
import com.iyoa.cleanaddis.data.posting.PostUUID
import com.iyoa.cleanaddis.entity.posting.Post
import io.reactivex.internal.util.NotificationLite.getValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
@ExperimentalCoroutinesApi
class PostViewModelTest {
    // Subject under test
    private lateinit var postViewModel : PostViewModel
    private lateinit var post : PostUUID

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule var instantExecutorRule = InstantTaskExecutorRule()

    //val post = Post("Title1", "Description1")

    @Before
    fun setupViewModel() {

       // postViewModel = PostViewModel()
    }

    @Test
    fun getActiveTaskFromRepositoryAndLoadIntoView() {
        postViewModel.getResponses

        // Then verify that the view was notified
        assertThat(postViewModel.post.get()!!.uuid).isEqualTo(this.post.uuid)

    }

}
