package com.dicoding.habitapp.ui.list

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dicoding.habitapp.R
import com.dicoding.habitapp.ui.add.AddHabitActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Habit (+), the AddHabitActivity displayed
@RunWith(AndroidJUnit4::class) // Using JUnit4
class HabitActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(HabitListActivity::class.java)

    @Test
    fun whenClickAddHabit_ShouldDisplayAddHabitActivity() {
        Intents.init() // Initialize Intents for capturing and verifying intents

        // Perform a click on the FloatingActionButton (fab) in the TaskActivity
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())

        // Verify that an intent to launch AddTaskActivity is sent
        Intents.intended(IntentMatchers.hasComponent(AddHabitActivity::class.java.name))

        Intents.release() // Release Intents resources
    }
}