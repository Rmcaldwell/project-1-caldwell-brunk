package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    public static final String EXTRA_MESSAGE = "spinnerText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String information = intent.getStringExtra("spinnerText");

        TextView buildingInfoView = (TextView) findViewById(R.id.buildingInfo);
        ImageView buildingImageView = (ImageView) findViewById(R.id.buildingImage);
        TextView buildingNameView = (TextView) findViewById(R.id.buildingName);

        if (information.equals("CIS Building")) {
            buildingNameView.setText(R.string.CISBuildingName);
            buildingImageView.setImageResource(R.drawable.cis);
            buildingInfoView.setText(R.string.CISBuildingInfo);
        }
        else if (information.equals("Cameron Hall")) {
            buildingNameView.setText(R.string.CameronHallName);
            buildingImageView.setImageResource(R.drawable.cameron);
            buildingInfoView.setText(R.string.CameronHallInfo);
        }
        else if (information.equals("Friday Hall")) {
            buildingNameView.setText(R.string.FridayHallName);
            buildingImageView.setImageResource(R.drawable.friday);
            buildingInfoView.setText(R.string.FridayHallInfo);
        }
    }
}
