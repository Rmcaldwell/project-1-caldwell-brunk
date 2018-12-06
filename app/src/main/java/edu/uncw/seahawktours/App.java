package edu.uncw.seahawktours;

import android.app.Application;
import android.app.Activity;
import android.provider.ContactsContract;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    private static BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();



        // Initialize the main data access object
        boxStore = MyObjectBox.builder().androidContext(App.this).build();

        // Get the wrapper (Box) for the Building table that lets us store Building objects
        Box<Building> buildingBox = boxStore.boxFor(Building.class);

        buildingBox.removeAll();

        // Initialize with some data
        if (buildingBox.count() == 0) {
            List<Building> initialBuildings = new ArrayList<>();
            initialBuildings.add(new Building("Cameron Hall", R.string.Cameron_url, R.drawable.cameron, R.string.CameronCaption, R.string.CameronHallInfo));
            initialBuildings.add(new Building("Computer Information Systems Building", R.string.CIS_url, R.drawable.cis, R.string.CISCaption, R.string.CISBuildingInfo));
            initialBuildings.add(new Building("Dobo Hall", R.string.Dobo_url, R.drawable.dobo, R.string.DoboCaption, R.string.DoboInfo));
            initialBuildings.add(new Building("Friday Hall", R.string.Friday_url, R.drawable.friday, R.string.FridayCaption, R.string.FridayHallInfo));
            initialBuildings.add(new Building("Galloway Residence Hall", R.string.Galloway_url, R.drawable.galloway, R.string.GallowayCaption, R.string.GallowayInfo));
            initialBuildings.add(new Building("Kresge Greenhouse", R.string.Kresge_url, R.drawable.kresge, R.string.KresgeCaption, R.string.KresgeInfo));
            initialBuildings.add(new Building("Leutze Hall", R.string.Leutze_url, R.drawable.leutze, R.string.LeutzeCaption, R.string.LeutzeInfo));
            initialBuildings.add(new Building("Randall Library", R.string.Randall_url, R.drawable.randall, R.string.RandallCaption, R.string.RandallInfo));
            initialBuildings.add(new Building("Shinn Plaza", R.string.Shinn_url, R.drawable.shinn, R.string.ShinnCaption, R.string.ShinnInfo));
            initialBuildings.add(new Building("Wagoner Hall", R.string.Wag_url, R.drawable.wag, R.string.WagCaption, R.string.WagInfo));


            // ObjectBox is smart enough to handle CRUD on Collections of entities
            buildingBox.put(initialBuildings);
        }

    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }


}
