package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
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


public class MainActivity extends AppCompatActivity {

    //MARK: Properties
    Spinner buildingName;

    private static Context context;

    private ShareActionProvider shareActionProvider;

    private MenuItem itemToHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        context = this;

        // Create array adapter to populate the spinner
        ArrayAdapter<String> buildingArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Building.buildingNames);

        //Get a reference to the Spinner
        buildingName = (Spinner) findViewById(R.id.buildingsSpinner);
        buildingName.setAdapter(buildingArrayAdapter);
    }


//Clicking the  button makes the new activity to pop up with a picture and details of the building selected
public void onClickFindBuilding(View view)
    {
        //Get a reference to the Spinner
//        Spinner buildingName = (Spinner) findViewById(R.id.buildingsSpinner);

        //Get selection from spinner
        String spinnerText = buildingName.getSelectedItem().toString();

        //Create an intent for DetailActivity
        Intent intent = new Intent(this, DetailActivity.class);

        //Send text from spinner to intent object.
        intent.putExtra(DetailActivity.EXTRA_MESSAGE, spinnerText);

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
        itemToHide = menu.findItem(R.id.action_share);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_info:
                Intent intent = new Intent (this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_share:
                itemToHide.setVisible(false);
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
