package edu.uncw.seahawktours;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayoutManager;
import java.util.ArrayList;
import java.util.List;
import io.objectbox.Box;
import io.objectbox.BoxStore;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    //MARK: Properties

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Box<Building> buildingBox = (App.getBoxStore().boxFor(Building.class));
        List<Building> buildings = buildingBox.getAll();

        ArrayList<String> buildingNames = new ArrayList<>();
        for (int i = 0; i < buildings.size(); i++) {
            buildingNames.add(buildings.get(i).getNameId());
        }

        RecyclerView buildingRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_main, container,false);
//
//        String[] building_names = new String[Building.buildingNames.length];
//        for (int i = 0; i < building_names.length; i++)  {
//            building_names[i] = Building.buildingNames[i];
//        }

//        int[] buildingImages = new int[Building.buildingNames.length];
//        for (int i = 0; i < buildingImages.length; i++) {
//            buildingImages[i] = Building.buildingNames[i]
//        }

        // Create arrays of
        int[] images = { R.drawable.cameron, R.drawable.friday, R.drawable.shinn, R.drawable.cis};

        // Create recyclerView
        CaptionedBuildingsAdapter adapter = new CaptionedBuildingsAdapter(buildingNames, images);
        buildingRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        buildingRecycler.setLayoutManager(layoutManager);

        // Make cards in recyclerView respond to clicks
        adapter.setListener(new CaptionedBuildingsAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.getAppContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MESSAGE, position);
                startActivity(intent);
            }
        });
        return buildingRecycler;
    }

    public void onClickFindBuilding(View view)
    {
        // ***************** Old code with spinner **********************
//        //Get a reference to the Spinner
////        Spinner buildingName = (Spinner) findViewById(R.id.buildingsSpinner);
//
//        //Get selection from spinner
//        String spinnerText = buildingName.getSelectedItem().toString();
//
//        //Create an intent for DetailActivity
//        Intent intent = new Intent(MainActivity.getAppContext(), DetailActivity.class);
//
//        //Send text from spinner to intent object.
//        intent.putExtra(DetailActivity.EXTRA_MESSAGE, spinnerText);
//
//        //Start DetailActivity with the intent
//        startActivity(intent);
    }

}
