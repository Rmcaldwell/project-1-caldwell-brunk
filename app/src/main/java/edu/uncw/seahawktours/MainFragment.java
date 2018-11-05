package edu.uncw.seahawktours;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    //MARK: Properties
    Spinner buildingName;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onClickFindBuilding(View view)
    {
        //Get a reference to the Spinner
//        Spinner buildingName = (Spinner) findViewById(R.id.buildingsSpinner);

        //Get selection from spinner
        String spinnerText = buildingName.getSelectedItem().toString();

        //Create an intent for DetailActivity
        Intent intent = new Intent(MainActivity.getAppContext(), DetailActivity.class);

        //Send text from spinner to intent object.
        intent.putExtra(DetailActivity.EXTRA_MESSAGE, spinnerText);

        //Start DetailActivity with the intent
        startActivity(intent);
    }

}
