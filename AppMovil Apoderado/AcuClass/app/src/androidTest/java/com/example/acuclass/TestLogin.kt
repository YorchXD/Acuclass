package com.example.acuclass

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import com.example.acuclass.ui.view.activities.LoginActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestLogin {
    private lateinit var correo: String
    private lateinit var clave: String
    private lateinit var tituloMenu: String

    @get:Rule
    var activityRule: ActivityScenarioRule<LoginActivity> = ActivityScenarioRule(LoginActivity::class.java)

    @Before
    fun initValidString()
    {
        correo = "yorch5.77@gmail.com"
        clave = "12345"
        tituloMenu = "Menú principal"
    }

    @Test
    fun iniciarSesion()
    {
        onView(withId(R.id.correo)).perform(typeText(correo), closeSoftKeyboard())
        onView(withId(R.id.clave)).perform(typeText(clave), closeSoftKeyboard())
        onView(withId(R.id.btnIniciarSesion)).perform(click())
        onView(withId(R.id.titleMenu)).check(matches(withText(tituloMenu)))
    }
}
