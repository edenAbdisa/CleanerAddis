package com.iyoa.cleanaddis.integratedTesting

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.open
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions.navigateTo
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.controller.posting.DisplayPostsRecyclerViewFragment
import com.iyoa.cleanaddis.controller.posting.PostFragment
import com.iyoa.cleanaddis.controller.posting.SelectPictureToPostFragment
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_post.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
@RunWith(AndroidJUnit4::class)
@LargeTest
class NavigationTesting   {

    @Test
    fun drawerNavigationFromMainToOthers() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        dataBindingIdlingResource.monitorActivity(activityScenario)

        onView(withId(R.id.drawer_layout))
            .check(matches(isClosed(Gravity.START)))
            .perform(open())

        onView(withId(R.id.drawer_layout))
            .perform(navigateTo(R.id.nav_postFragment))
        //add the other navigation
    }


    @Test
    fun testNavigationFromSelectPictureToPostFragmentToOther() {
        // Create a mock NavController
        val mockNavController = mock(NavController::class.java)

        val postScenario = launchFragmentInContainer<SelectPictureToPostFragment>()

        postScenario.onFragment { fragment ->
            Navigation  .setViewNavController(fragment.navigation_bottom_bar, mockNavController)
        }

        // Verify that performing a click prompts the correct Navigation action
        onView(ViewMatchers.withId(R.id.postAccountFragment)).perform(ViewActions.click())
        verify(mockNavController).navigate(R.id.action_postFragment_to_postAccountFragment)

        onView(ViewMatchers.withId(R.id.displayPostsRecyclerViewFragment)).perform(ViewActions.click())
        verify(mockNavController).navigate(R.id.action_postFragment_to_displayPostsRecyclerViewFragment)

        onView(ViewMatchers.withId(R.id.selectPictureToPostFragment)).perform(ViewActions.click())
        verify(mockNavController).navigate(R.id.action_postFragment_to_selectPictureToPostFragment)
    }
    @Test
    fun testNavigationFromPostToOther() {
        // Create a mock NavController
        val mockNavController = mock(NavController::class.java)

        val postScenario = launchFragmentInContainer<PostFragment>()

        postScenario.onFragment { fragment ->
            Navigation  .setViewNavController(fragment.navigation_bottom_bar, mockNavController)
        }

        // Verify that performing a click prompts the correct Navigation action
        onView(ViewMatchers.withId(R.id.postAccountFragment)).perform(ViewActions.click())
        verify(mockNavController).navigate(R.id.action_postFragment_to_postAccountFragment)

        onView(ViewMatchers.withId(R.id.displayPostsRecyclerViewFragment)).perform(ViewActions.click())
        verify(mockNavController).navigate(R.id.action_postFragment_to_displayPostsRecyclerViewFragment)

        onView(ViewMatchers.withId(R.id.selectPictureToPostFragment)).perform(ViewActions.click())
        verify(mockNavController).navigate(R.id.action_postFragment_to_selectPictureToPostFragment)
    }
}