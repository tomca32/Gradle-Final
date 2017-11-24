import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class JokeShowing {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup() {
        Espresso.registerIdlingResources(activityActivityTestRule.getActivity().getIdlingResource());
    }

    @Test
    public void pressingTellJokeButtonLaunchesAnActivityDisplayingAnAwfulJoke() throws Exception {
        onView(withId(R.id.get_joke_button)).perform(click());

        onView(withId(R.id.joke_text)).check(matches(withText("Awful Joke from the JokeTeller Library")));
    }
}
