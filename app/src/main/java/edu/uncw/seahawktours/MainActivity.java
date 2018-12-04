package edu.uncw.seahawktours;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
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
import android.Manifest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import io.objectbox.Box;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //MARK: Properties
    private ShareActionProvider shareActionProvider;

    // Location properties
    private static final int REQUEST_CODE = 1000;
    FusedLocationProviderClient fusedLocationProviderClient;
    LocationRequest locationRequest;
    LocationCallback locationCallback;

    private static Context context;

    public double latitude;
    public double longitude;


    // *********************** Location Management ************************** //
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

                    }
                }
            }
        }
    }
    // *********************************************************************** //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        // Navigation Menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ***********************************************************************************

        context = this;
        // ********************** LOCATION ***************************************************
        // Check permissions at runtime
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);

        } else {

            // If permission is granted
            buildLocationRequest();
            buildLocationCallback();

            // Create FusedProviderClient
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        }

        // Get location
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
        // *************************************************************************************


    }

    private void buildLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setSmallestDisplacement(10);
    }

    // ************************** More location management ******************************** //
    private void buildLocationCallback() {
        locationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                for (Location location:locationResult.getLocations()) {
                    // Get location lat and lon
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                }

            }
        };
    }
    // ************************************************************************************* //

//Clicking the  button makes the new activity to pop up with a picture and details of the building selected
//public void onClickFindBuilding(View view)
//    {
//        //Create an intent for DetailActivity
//        Intent intent = new Intent(this, DetailActivity.class);
//
//        //Start DetailActivity with the intent
//        startActivity(intent);
//    }
//
    public static Context getAppContext() {

        return context;
    }

    // Create "..." menu
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //Inflate the menu; this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_share).setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    // Make menu items respond to clicks
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

    // Navigation menu methods
    //This method gets called when the user clicks on one of the items in the drawer
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

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
