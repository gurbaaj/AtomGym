package com.javahelps.atomgym;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;

import com.javahelps.atomgym.BottomFragments.FeedsFragment;
import com.javahelps.atomgym.BottomFragments.GrowthFragment;
import com.javahelps.atomgym.BottomFragments.NotificationsFragment;
import com.javahelps.atomgym.BottomFragments.TutorialsFragment;
import com.javahelps.atomgym.BottomFragments.WorkoutFragment;
import com.javahelps.atomgym.NavigationActivities.AboutUsActivity;
import com.javahelps.atomgym.NavigationActivities.FacebookLinkActivity;
import com.javahelps.atomgym.NavigationActivities.NotificationActivity;
import com.javahelps.atomgym.NavigationActivities.PasswordActivity;
import com.javahelps.atomgym.NavigationActivities.ProfileActivity;
import com.javahelps.atomgym.NavigationActivities.TermsActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    BottomBar mBottomBar;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setWindowAnimations(android.R.style.Animation_Toast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mBottomBar = (BottomBar)findViewById(R.id.bottomBar);
        mBottomBar.setDefaultTab(R.id.tab_workout);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab_feeds:
                        setTitle("Feeds");
                        FeedsFragment feedsFragment = new FeedsFragment();
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,feedsFragment).commit();
                        break;

                    case R.id.tab_growth:
                        setTitle("Growth");
                        GrowthFragment growthFragment = new GrowthFragment();
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,growthFragment).commit();
                        break;

                    case R.id.tab_workout:
                        setTitle("Workout");
                        WorkoutFragment  workoutFragment = new WorkoutFragment();
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,workoutFragment).commit();
                        break;

                    case R.id.tab_notify:
                        setTitle("Notifications");
                        NotificationsFragment notificationsFragment = new NotificationsFragment();
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,notificationsFragment).commit();
                        break;

                    case R.id.tab_tuts:
                        setTitle("Tutorials");
                        TutorialsFragment tutorialsFragment = new TutorialsFragment();
                        fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_main,tutorialsFragment).commit();
                        break;

                }
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent myprofile = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(myprofile);
        }
        else if (id == R.id.facebook) {
            Intent facebook = new Intent(MainActivity.this, FacebookLinkActivity.class);
            startActivity(facebook);
        }
        else if (id == R.id.notification) {
            Intent facebook = new Intent(MainActivity.this, NotificationActivity.class);
            startActivity(facebook);
        }
        else if (id == R.id.changePassword) {
            Intent facebook = new Intent(MainActivity.this, PasswordActivity.class);
            startActivity(facebook);
        }
        else if (id == R.id.about) {
            Intent facebook = new Intent(MainActivity.this, AboutUsActivity.class);
            startActivity(facebook);
        }
        else if (id == R.id.terms) {
            Intent facebook = new Intent(MainActivity.this, TermsActivity.class);
            startActivity(facebook);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
