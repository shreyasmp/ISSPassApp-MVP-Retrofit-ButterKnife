package shreyasmuthkur.retrofit_mvp_iss.runner;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import shreyasmuthkur.retrofit_mvp_iss.espressorobot.Robot;
import shreyasmuthkur.retrofit_mvp_iss.views.ISSPassActivity;

/**
 * Created by shreyasmp on 4/5/18.
 * <p>
 * Class to run UI Tests on the app, with TDD approach used for developing this app.
 * Have made use of reusable test events from Robot class for performing various tests.
 * Since there is a overhead of network call, Espresso has to be informed to sync actions
 * when performing tests
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RunTest {

    @Rule
    public IntentsTestRule<ISSPassActivity> issPassActivityIntentsTestRule =
            new IntentsTestRule<>(ISSPassActivity.class);

    private Robot robot = new Robot();

    @Before
    public void registerResource() {
        IdlingRegistry.getInstance().register(issPassActivityIntentsTestRule.getActivity().getIdlingResource());
    }

    @SmallTest
    public void initialScreenShow() {
        robot.progressBarHidden();
    }

    @Test
    public void clickButtonTest() {
        robot.clickButton()
                .progressBarHidden()
                .errorNotDisplayed();
    }

    @After
    public void unRegisterResource() {
        IdlingRegistry.getInstance().unregister(issPassActivityIntentsTestRule.getActivity().getIdlingResource());
    }
}
