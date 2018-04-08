package shreyasmuthkur.retrofit_mvp_iss.idling;

import android.support.test.espresso.IdlingResource;

/**
 * Created by shreyasmp on 4/5/18.
 * <p>
 * This class holds the counter and idle resource tracking for tests that are run
 * Reference {@link IdlingResource}
 */


public class EspressoIdling {

    public static ISSPassIdlingResource issPassIdlingResource = new ISSPassIdlingResource("Pass");

    public static void incrementCounter() {
        issPassIdlingResource.incrementCounter();
    }

    public static void decrementCounter() {
        issPassIdlingResource.decrementCounter();
    }

    public static IdlingResource getIdlingResource() {
        return issPassIdlingResource;
    }
}
