package com.iyoa.cleanaddis.endToEndTesting

import com.iyoa.cleanaddis.MainActivity
import com.iyoa.cleanaddis.R
import com.iyoa.cleanaddis.controller.posting.PostFragment

class PostFragmentTest{

    @Test
    fun navigateToPostUiFragments() {
        val activityScenario = ActivityScenario.launch(PostFragment::class.java)
        dataBindingIdlingResource.monitorActivity(activityScenario)
        onView(withId(R.id.navigation_home)).perform(click())
        onView(withId(R.id.navigation_account)).perform(click())
        onView(withId(R.id.navigation_add_image)).perform(click())
    }
}