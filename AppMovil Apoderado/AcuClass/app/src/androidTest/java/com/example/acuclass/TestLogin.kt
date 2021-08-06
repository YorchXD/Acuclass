package com.example.acuclass

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import com.example.acuclass.view.LoginActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestLogin {
    private lateinit var correo: String

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity> = ActivityScenarioRule(LoginActivity::class.java)

    @Before
    fun initValidString()
    {
        correo = "yorch5.77@gmail.com"
    }

    @Test
    fun cambiarTextoEmail()
    {
        onView(withId(R.id.correo))
            .perform(typeText(correo), closeSoftKeyboard())

        onView(withId(R.id.correo))
            .check(matches(withText(correo)))
    }
}
