package fr.android.androidexercises;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.core.deps.guava.collect.Iterables;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitor;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.test.ActivityInstrumentationTestCase2;

import com.squareup.spoon.Spoon;

import org.hamcrest.Matchers;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    public void takeScreenshot(String name) {
        Spoon.screenshot(getCurrentActivity(), name);
    }

    public void testShouldLogin(){

        takeScreenshot("initial_state");

        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit))
                .perform(ViewActions.typeText("passowrd"));

        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.loggedText))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        Espresso.onView(ViewMatchers.withText(R.string.text_logged))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        takeScreenshot("logged_state");

    }

    public void testShouldNotLogin(){

        Espresso.onView(ViewMatchers.withId(R.id.passwordEdit))
                .perform(ViewActions.typeText("wd"));

        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.loggedText))
                .check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())));

    }

    public Activity getCurrentActivity() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.waitForIdleSync();
        final Activity[] activity = new Activity[1];
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
                java.util.Collection<Activity> resumedActivities = activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
                activity[0] = Iterables.getOnlyElement(resumedActivities);
            }
        });
        return activity[0];
    }

}