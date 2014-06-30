package com.exads.comeworld.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.exads.comeworld.app.fragment.EditFragments;
import com.exads.comeworld.app.fragment.ListFragments;
import com.exads.comeworld.app.fragment.NavigationDrawerFragment;
import com.exads.comeworld.app.fragment.SettingFragments;
import com.exads.comeworld.app.helper.MenuHelper;


/**
 * Created by come on 24/06/14.
 */
public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (position == 0)
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new EditFragments(), MenuHelper.navigationTab[0])
                    .commit();
        if (position == 1)
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new ListFragments(), MenuHelper.navigationTab[1])
                    .commit();
        if (position == 2)
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new SettingFragments(), MenuHelper.navigationTab[2])
                    .commit();
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        if (!mNavigationDrawerFragment.isDrawerOpen()) {
        // Only show items in the action bar relevant to this screen
        // if the drawer is not showing. Otherwise, let the drawer
        // decide what to show in the action bar.
//        getMenuInflater().inflate(R.menu.main, menu);
        restoreActionBar();
//        return true;
//        }
        return super.onCreateOptionsMenu(menu);
    }
}
