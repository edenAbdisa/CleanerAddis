package com.iyoa.cleanaddis.endToEndTesting

import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R

class MainFragmentTest{

    @Test
    fun navigateToFragments() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        dataBindingIdlingResource.monitorActivity(activityScenario)
        onView(withId(R.id.nav_camera)).perform(click())
        onView(withId(R.id.nav_post)).perform(click())
        onView(withId(R.id.nav_slideshow)).perform(click())
        onView(withId(R.id.nav_manage)).perform(click())
    }
}