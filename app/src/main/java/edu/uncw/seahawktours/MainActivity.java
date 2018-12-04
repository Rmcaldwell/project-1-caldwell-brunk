package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.support.v7.widget.ShareActionProvider;
import android.support.v4.view.MenuItemCompat;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //MARK: Properties
    Spinner buildingName;

    private static Context context;

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        context = this;

        //Navigation Drawer Implementation
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.nav_open_drawer,R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        Fragment fragment = new InboxFragment();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.content_frame, fragment);
//        ft.commit();
    }


//Clicking the  button makes the new activity to pop up with a picture and details of the building selected
public void onClickFindBuilding(View view)
    {
        //Create an intent for DetailActivity
        Intent intent = new Intent(this, DetailActivity.class);

        //Start DetailActivity with the intent
        startActivity(intent);
    }

    public static Context getAppContext() {

        return context;
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //Inflate the menu; this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_share).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                Intent intent = new Intent (this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //This method gets called when the user clicks on one of the items in the drawer
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;

        switch(id){
            case R.id.nav_about:
                intent = new Intent(this, AboutActivity.class);
                break;
            case R.id.nav_help:
                intent = new Intent(this, AboutActivity.class);
                break;
            case R.id.nav_feedback:
                intent = new Intent(this, AboutActivity.class);
            break;
        }

        startActivity(intent);

//        if (fragment != null) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.content_frame, fragment);
//            ft.commit();
//        } else {
//            startActivity(intent);
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //When the user presses the back button, close the drawer if its opem
    @Override
    public void onBackPressed() {
        DrawerLayout drawer =(DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
