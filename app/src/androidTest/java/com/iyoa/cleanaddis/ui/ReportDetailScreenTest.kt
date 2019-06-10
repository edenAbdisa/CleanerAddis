package com.iyoa.cleanaddis.ui

import androidx.navigation.NavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.runner.AndroidJUnit4
import com.iyoa.cleanaddis.R
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito


@RunWith(AndroidJUnit4::class)
class ReportDetailScreenTest {

    @Test
    fun test1() {

        val mockNavController = Mockito.mock(NavController::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.report_cardview)).perform(ViewActions.click())
        Mockito.verify(mockNavController).navigate(R.id.action_report_list_to_report_detail)
    }
}