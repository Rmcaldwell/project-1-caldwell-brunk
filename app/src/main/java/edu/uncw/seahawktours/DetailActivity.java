package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

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
        TextView URLView = (TextView) findViewById(R.id.buildingURL);

        if (information.equals("CIS Building")) {
            buildingNameView.setText(R.string.CISBuildingName);
            buildingImageView.setImageResource(R.drawable.cis);
            buildingInfoView.setText(R.string.CISBuildingInfo);
            captionView.setText(R.string.CISCaption);
            URLView.setText(R.string.CIS_url);
        }
        else if (information.equals("Cameron Hall")) {
            buildingNameView.setText(R.string.CameronHallName);
            buildingImageView.setImageResource(R.drawable.cameron);
            buildingInfoView.setText(R.string.CameronHallInfo);
            captionView.setText(R.string.CameronCaption);
            URLView.setText(R.string.Cameron_url);
        }
        else if (information.equals("Friday Hall")) {
            buildingNameView.setText(R.string.FridayHallName);
            buildingImageView.setImageResource(R.drawable.friday);
            buildingInfoView.setText(R.string.FridayHallInfo);
            captionView.setText(R.string.FridayCaption);
            URLView.setText(R.string.Friday_url);
        }
        else if (information.equals("Kresge Greenhouse")) {
            buildingNameView.setText(R.string.KresgeName);
            buildingImageView.setImageResource(R.drawable.kresge);
            buildingInfoView.setText(R.string.KresgeInfo);
            captionView.setText(R.string.FridayCaption);
            URLView.setText(R.string.Kresge_url);
        }
        else if (information.equals("Shinn Plaza")) {
            buildingNameView.setText(R.string.ShinnName);
            buildingImageView.setImageResource(R.drawable.shinn);
            buildingInfoView.setText(R.string.ShinnInfo);
            captionView.setText(R.string.ShinnCaption);
            URLView.setText(R.string.Shinn_url);
        }
    }
}

