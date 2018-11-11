package com.sniper.bdd.cucumber.espresso.login

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import com.sniper.bdd.LoginActivity
import com.sniper.bdd.R
import java.lang.Thread.sleep

class LoginScreenRobot {

    fun launchLoginScreen(testRule: ActivityTestRule<LoginActivity>): LoginScreenRobot {
        testRule.launchActivity(null)
        return this
    }

    fun selectEmailField(): LoginScreenRobot {
        onView(withId(R.id.email)).perform(click())
        return this
    }

    fun selectPasswordField(): LoginScreenRobot {
        onView(withId(R.id.password)).perform(click())
        return this
    }

    fun enterEmail(email: String): LoginScreenRobot {
        onView(withId(R.id.email)).perform(typeText(email))
        return this
    }

    fun enterPassword(password: String): LoginScreenRobot {
        onView(withId(R.id.password)).perform(typeText(password))
        return this
    }

    fun closeKeyboard(): LoginScreenRobot {
        Espresso.closeSoftKeyboard()
        sleep(100)
        return this
    }

    fun clickSignInButton(): LoginScreenRobot {
        onView(withText(InstrumentationRegistry.getTargetContext().getString(R.string.action_sign_in))).perform(click())
        return this
    }

    fun isSuccessfulLogin(): LoginScreenRobot {
        onView(withId(R.id.successful_login_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.successful_login_text_view)).check(matches(withText(R.string.successful_login)))
        return this
    }

}
