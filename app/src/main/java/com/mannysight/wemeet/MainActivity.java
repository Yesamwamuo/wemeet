package com.mannysight.wemeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Emmanuel on 1/20/2017.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpDrawer();
        showDrawer();

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_main_fragment_container);
        if (fragment == null) {
            fragment = FeedFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(R.id.activity_main_fragment_container, fragment)
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_items, menu);
        return true;
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Feed");
//        toolbar.setTitle("Headlines");
//        toolbar.inflateMenu(R.menu.menu_main);
//        toolbar.setOnMenuItemClickListener(this);
    }

    private void setUpDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//        item.setCheckable(true);
//        item.setChecked(true);  // This helps to know which Menu Item is Clicked
        hideDrawer();
        int id = 0;
        switch (item.getItemId()) {
            case R.id.item_feed:
                //set fragment
                break;

            case R.id.item_events:
                //set fragment
                break;

            case R.id.item_post:
                //set fragment
                break;

            case R.id.item_notifications:
                //set fragment
                break;

            case R.id.item_account:
                //set fragment
                break;

            case R.id.item_logout:
                //set fragment
                break;
        }
//        Intent intent = new Intent(context, WebsiteFeed.class);
//        intent.putExtra("image", Website.getImageId(id));
//        intent.putExtra("Id", id);
//        startActivity(intent);
        return true;
    }

    private void showDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }


    private void hideDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            hideDrawer();
        else
            super.onBackPressed();
    }

}
