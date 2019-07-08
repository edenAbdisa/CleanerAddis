package com.iyoa.cleanaddis.ui

import androidx.test.runner.AndroidJUnit4
import com.iyoa.cleanaddis.R





import androidx.navigation.NavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * A simple test class that can be run both on device (or emulator) or on the host (as a JVM test
 * using Robolectric).
 */
@RunWith(AndroidJUnit4::class)
class ArticleListScreenTest {

    @Test
    fun test1() {

        val mockNavController = mock(NavController::class.java)
        onView(withId(R.id.add_report_button)).perform(click())
        verify(mockNavController).navigate(R.id.action_report_list_to_add_report)
    }
}
