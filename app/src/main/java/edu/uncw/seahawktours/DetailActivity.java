package edu.uncw.seahawktours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.app.Fragment;

import java.util.List;

import io.objectbox.Box;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "BuildingId";

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(null);

        int buildingId = (Integer)getIntent().getExtras().get(EXTRA_MESSAGE);
        Box<Building> buildingBox = (App.getBoxStore().boxFor(Building.class));
        List<Building> buildings = buildingBox.getAll();
        String buildingName = buildings.get(buildingId).getNameId();

        TextView buildingInfoView = (TextView) findViewById(R.id.buildingInfo);
        ImageView buildingImageView = (ImageView) findViewById(R.id.buildingImage);
        TextView buildingNameView = (TextView) findViewById(R.id.buildingName);
        TextView captionView = (TextView) findViewById(R.id.caption);
        TextView URLView = (TextView) findViewById(R.id.buildingURL);

        if (buildingName.equals("Computer Information Systems Building")) {
            buildingNameView.setText(R.string.CISBuildingName);
            buildingImageView.setImageResource(R.drawable.cis);
            buildingInfoView.setText(R.string.CISBuildingInfo);
            captionView.setText(R.string.CISCaption);
            URLView.setText(R.string.CIS_url);
            //toolbar.setTitle(R.string.CISBuildingName);
        }
        else if (buildingName.equals("Cameron Hall")) {
            buildingNameView.setText(R.string.CameronHallName);
            buildingImageView.setImageResource(R.drawable.cameron);
            buildingInfoView.setText(R.string.CameronHallInfo);
            captionView.setText(R.string.CameronCaption);
            URLView.setText(R.string.Cameron_url);
        }
        else if (buildingName.equals("Friday Hall")) {
            buildingNameView.setText(R.string.FridayHallName);
            buildingImageView.setImageResource(R.drawable.friday);
            buildingInfoView.setText(R.string.FridayHallInfo);
            captionView.setText(R.string.FridayCaption);
            URLView.setText(R.string.Friday_url);
        }
        else if (buildingName.equals("Kresge Greenhouse")) {
            buildingNameView.setText(R.string.KresgeName);
            buildingImageView.setImageResource(R.drawable.kresge);
            buildingInfoView.setText(R.string.KresgeInfo);
            captionView.setText(R.string.KresgeCaption);
            URLView.setText(R.string.Kresge_url);
        }
        else if (buildingName.equals("Shinn Plaza")) {
            buildingNameView.setText(R.string.ShinnName);
            buildingImageView.setImageResource(R.drawable.shinn);
            buildingInfoView.setText(R.string.ShinnInfo);
            captionView.setText(R.string.ShinnCaption);
            URLView.setText(R.string.Shinn_url);

        } else if (buildingName.equals("Wagoner Hall")) {
            buildingNameView.setText(R.string.WagName);
            buildingImageView.setImageResource(R.drawable.wag);
            buildingInfoView.setText(R.string.WagInfo);
            captionView.setText(R.string.WagCaption);
            URLView.setText(R.string.Wag_url);

        } else if (buildingName.equals("Galloway Residence Hall")) {
            buildingNameView.setText(R.string.GallowayName);
            buildingImageView.setImageResource(R.drawable.galloway);
            buildingInfoView.setText(R.string.GallowayInfo);
            captionView.setText(R.string.GallowayCaption);
            URLView.setText(R.string.Galloway_url);

        } else if (buildingName.equals("Randall Library")) {
            buildingNameView.setText(R.string.RandallName);
            buildingImageView.setImageResource(R.drawable.randall);
            buildingInfoView.setText(R.string.RandallInfo);
            captionView.setText(R.string.RandallCaption);
            URLView.setText(R.string.Randall_url);

        }  else if (buildingName.equals("Leutze Hall")) {
            buildingNameView.setText(R.string.LeutzeName);
            buildingImageView.setImageResource(R.drawable.leutze);
            buildingInfoView.setText(R.string.LeutzeInfo);
            captionView.setText(R.string.LeutzeCaption);
            URLView.setText(R.string.Leutze_url);

        }  else if (buildingName.equals("Dobo Hall")) {
            buildingNameView.setText(R.string.DoboName);
            buildingImageView.setImageResource(R.drawable.dobo);
            buildingInfoView.setText(R.string.DoboInfo);
            captionView.setText(R.string.DoboCaption);
            URLView.setText(R.string.Dobo_url);
        }

    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //Inflate the menu; this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to join me for pizza?");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String text) {
        Intent intent = new Intent (Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
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

}

