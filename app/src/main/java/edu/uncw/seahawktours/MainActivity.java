package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //MARK: Properties
    Spinner buildingName = (Spinner) findViewById(R.id.buildingsSpinner);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Building> buildingArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Building.buildings);

        //Get a reference to the Spinner
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

}
