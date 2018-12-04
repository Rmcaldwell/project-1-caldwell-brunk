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
            initialBuildings.add(new Building("CIS Building"));
            initialBuildings.add(new Building("Cameron Hall"));
            initialBuildings.add(new Building("Shinn Plaza"));
            initialBuildings.add(new Building("Dobo"));
            initialBuildings.add(new Building("Randall"));
            initialBuildings.add(new Building("Kresge Greenhouse"));
            initialBuildings.add(new Building("Friday Hall"));

            // ObjectBox is smart enough to handle CRUD on Collections of entities
            buildingBox.put(initialBuildings);
        }

    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }


}
