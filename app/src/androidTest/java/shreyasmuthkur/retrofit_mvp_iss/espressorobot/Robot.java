package shreyasmuthkur.retrofit_mvp_iss.espressorobot;

import android.support.test.espresso.assertion.ViewAssertions;

import shreyasmuthkur.retrofit_mvp_iss.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 *
 *  Class Robot used for creating espresso based test events that perform text match and click actions
 * The reusable components written here can be used for multiple combination of tests for each test cases
 * TDD approach is used here for the app
 */

public class Robot {

    public Robot clickButton() {
        onView(withId(R.id.get_current_gps_button)).perform(click());
        return this;
    }

    public Robot progressBarHidden() {
        onView(withId(R.id.progress_bar)).check(ViewAssertions.matches(not(isDisplayed())));
        return this;
    }

    public Robot errorDisplayed() {
        onView(withId(R.id.service_error_message)).check(ViewAssertions.matches(isDisplayed()));
        return this;
    }

    public Robot errorNotDisplayed() {
        onView(withId(R.id.service_error_message)).check(ViewAssertions.matches(not(isDisplayed())));
        return this;
    }
}
