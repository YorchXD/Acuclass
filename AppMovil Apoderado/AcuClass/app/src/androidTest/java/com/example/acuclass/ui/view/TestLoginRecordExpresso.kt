package com.example.acuclass.ui.view


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import com.example.acuclass.R
import com.example.acuclass.ui.view.activities.SplashActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TestLoginRecordExpresso
{
    @Rule
    @JvmField
    var mActivityTestRule = ActivityScenarioRule(SplashActivity::class.java)

    @Test
    fun testLoginRecordExpresso()
    {
        /*Ingresa el correo*/
        val textInputEditText = onView(allOf(withId(R.id.correo),
                                        childAtPosition(childAtPosition(withId(R.id.usuarioTextField),0), 0),
                                        isDisplayed()))
        textInputEditText.perform(replaceText("yorch5.77@gmail.com"), closeSoftKeyboard())

        /*Ingresa la contraseña*/
        val textInputEditText2 = onView(allOf(childAtPosition(childAtPosition(withId(R.id.claveTextField), 0), 0),
                                        isDisplayed()))
        textInputEditText2.perform(replaceText("12345"), closeSoftKeyboard())

        /*Muestra la clave*/
        val checkableImageButton = onView(
                                        allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                                        childAtPosition(childAtPosition(withClassName(`is`("android.widget.LinearLayout")), 1), 0),
                                        isDisplayed()))
        checkableImageButton.perform(click())

        /*Oculta la clave*/
        val checkableImageButton2 = onView(
                                        allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                                        childAtPosition(childAtPosition(withClassName(`is`("android.widget.LinearLayout")), 1), 0),
                                        isDisplayed()))
        checkableImageButton2.perform(click())

        /*Inicia sesion*/
        val materialButton = onView(
                                    allOf(withId(R.id.btnIniciarSesion), withText("Iniciar sesión"),
                                    childAtPosition(childAtPosition(withClassName(`is`("android.widget.LinearLayout")), 1), 2),
                                    isDisplayed()))
        materialButton.perform(click())

        /*Chequea si estoy en la vista menu principal*/
        val textView = onView(allOf(withText("Menú principal"),
                            withParent(withParent(withId(R.id.contenedorFragments))),
                            isDisplayed()))
        textView.check(matches(withText("Menú principal")))
    }
    
    private fun childAtPosition(parentMatcher: Matcher<View>, position: Int): Matcher<View>
    {
        return object : TypeSafeMatcher<View>()
        {
            override fun describeTo(description: Description)
            {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean
            {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent) && view == parent.getChildAt(position)
            }
        }
    }
}
