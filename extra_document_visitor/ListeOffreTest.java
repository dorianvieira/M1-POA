package miage.parisnanterre.fr.mynanterre;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListeOffreTest {

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("miage.parisnanterre.fr.mynanterre", appContext.getPackageName());
    }

    /*on dit que nos tests seront effectués sur la classe ListeOffre*/
    @Rule
    public ActivityTestRule<ListeOffre> activityActivityTestRule = new ActivityTestRule<>(ListeOffre.class);

    @Before
    public void init(){
        activityActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }
    /* pour la methode ActionFonctionneElementListe
    @Before
    public void unlockScreen() {
        final CategorySelectionActivity activity = activityActivityTestRule.getActivity();
        Runnable wakeUpDevice = new Runnable() {
            public void run() {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
                        WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        };
        activity.runOnUiThread(wakeUpDevice);
    }
*/
    /*on va tester si une action ce produit si on clique sur le 1er element de la liste*/
    @Test
    public void ActionFonctionneElementListe() throws Exception{
        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

   /*regarder si le 1er élément est visible*/
    @Test
    public void listViewTest() {
        onView(withId(R.id.ligne)).perform(click());
    }

    @Test
    public void lastItem_NotDisplayed(){
        onView(withText("Développeur Web H/F")).check(doesNotExist());
    }


    /*verifier l'element cliquer et si l'activite a detetcte le clic*/
    @Test
    public void testClickOnListItem()
    {
        onData(hasEntry(equalTo(Offre.class),is("List item: 25")))
                .onChildView(withId(R.id.ligne)).perform(click());
        onView(withId(R.id.ligne_child)).check(matches(withText("25")));
    }

}

