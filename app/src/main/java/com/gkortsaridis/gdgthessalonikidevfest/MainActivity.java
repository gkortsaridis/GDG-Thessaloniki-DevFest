package com.gkortsaridis.gdgthessalonikidevfest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.gkortsaridis.gdgthessalonikidevfest.Calendar.CalendarFragment;
import com.gkortsaridis.gdgthessalonikidevfest.News.NewsFeedFragment;
import com.gkortsaridis.gdgthessalonikidevfest.Speakers.SpeakersFragment;
import com.gkortsaridis.gdgthessalonikidevfest.Sponsors.SponsorsFragment;
import com.gkortsaridis.gdgthessalonikidevfest.Team.TeamFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    String what;
    ActionBarDrawerToggle mDrawerToggle;
    NavigationView view;
    ArrayList<String> history;

    private FirebaseAnalytics mFirebaseAnalytics;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        history = new ArrayList<>();

        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        view = (NavigationView) findViewById(R.id.navigation_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.VALUE, "OPENED");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        FirebaseCrash.log("Activity created");


        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar ,  R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        view.getMenu().getItem(0).setChecked(true);
        MainActivity.this.what = "Calendar";
        setFragment("Calendar");

        view.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Snackbar.make(MainActivity.this.findViewById(R.id.your_placeholder), menuItem.getTitle(), Snackbar.LENGTH_SHORT).show();

                if(!MainActivity.this.what.equals(menuItem.getTitle().toString())) {
                    MainActivity.this.setFragment(menuItem.getTitle().toString());
                    MainActivity.this.what = menuItem.getTitle().toString();
                }
                MainActivity.this.drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    public void setFragment(String what) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

        if (what.equals("#GDGThess Live Feed")) {
            ft.replace(R.id.your_placeholder, new NewsFeedFragment());
            getSupportActionBar().setElevation(20);
            view.setCheckedItem(R.id.navItem2);
        } else if (what.equals("Calendar")) {
            ft.replace(R.id.your_placeholder, new CalendarFragment());
            getSupportActionBar().setElevation(0);
            view.setCheckedItem(R.id.navItem1);
        } else if (what.equals("Speakers")) {
            ft.replace(R.id.your_placeholder, new SpeakersFragment());
            getSupportActionBar().setElevation(20);
            view.setCheckedItem(R.id.navItem3);
        } else if (what.equals("Partners")) {
            ft.replace(R.id.your_placeholder, new SponsorsFragment());
            getSupportActionBar().setElevation(20);
            view.setCheckedItem(R.id.navItem5);
        } else if (what.equals("Team")) {
            ft.replace(R.id.your_placeholder, new TeamFragment());
            getSupportActionBar().setElevation(20);
            view.setCheckedItem(R.id.navItem4);
        }

        ft.commit();
        getSupportActionBar().setTitle(what);
        history.add(what);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("what", what);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("onRestore","InstanceState");
        setFragment(savedInstanceState.getString("what", "Calendar"));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onBackPressed() {
        if (this.drawerLayout == null || !this.drawerLayout.isDrawerOpen(GravityCompat.START)) {

            if(history.size() == 1) {
                new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("Exit").setMessage("You are about to close the app").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        MainActivity.this.startActivity(intent);
                        MainActivity.this.finish();
                    }
                }).setNegativeButton("No", null).show();
            }else{
                String current = history.remove(history.size()-1);
                String previous = history.remove(history.size()-1);
                setFragment(previous);
            }
        } else if (this.drawerLayout != null) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
}
