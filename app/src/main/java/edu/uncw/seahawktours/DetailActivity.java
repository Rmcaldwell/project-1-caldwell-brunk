package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        TextView captionView = (TextView) findViewById(R.id.caption);

        if (information.equals("CIS Building")) {
            buildingNameView.setText(R.string.CISBuildingName);
            buildingImageView.setImageResource(R.drawable.cis);
            buildingInfoView.setText(R.string.CISBuildingInfo);
            captionView.setText(R.string.CISCaption);
        }
        else if (information.equals("Cameron Hall")) {
            buildingNameView.setText(R.string.CameronHallName);
            buildingImageView.setImageResource(R.drawable.cameron);
            buildingInfoView.setText(R.string.CameronHallInfo);
            captionView.setText(R.string.CameronCaption);
        }
        else if (information.equals("Friday Hall")) {
            buildingNameView.setText(R.string.FridayHallName);
            buildingImageView.setImageResource(R.drawable.friday);
            buildingInfoView.setText(R.string.FridayHallInfo);
            captionView.setText(R.string.FridayCaption);
        }
    }
}

