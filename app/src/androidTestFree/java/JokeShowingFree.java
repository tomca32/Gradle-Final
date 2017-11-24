import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.free.FreeMainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

@RunWith(AndroidJUnit4.class)
public class JokeShowingFree {

    @Rule
    public ActivityTestRule<FreeMainActivity> activityTestRule = new ActivityTestRule<>(FreeMainActivity.class);

    @Before
    public void setup() {
        Espresso.registerIdlingResources(activityTestRule.getActivity().getIdlingResource());
    }

    @Test
    public void pressingTellJokeButtonShowsAnAdThenLaunchesAnActivityDisplayingAnAwfulJoke() throws Exception {
        onView(withId(R.id.get_joke_button)).perform(click());

        ViewInteraction closeInterstitialButton = onView(allOf(withContentDescription("Interstitial close button"), isDisplayed()));
        closeInterstitialButton.perform(click());

        onView(withId(R.id.joke_text)).check(matches(withText("Awful Joke from the JokeTeller Library")));
    }
}
