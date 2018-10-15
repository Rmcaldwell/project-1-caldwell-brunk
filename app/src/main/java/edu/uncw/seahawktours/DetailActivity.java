package edu.uncw.seahawktours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    public static final String EXTRA_MESSAGE = "spinnerText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String string = intent.getStringExtra("spinnerText");


        TextView textView = (TextView) findViewById(R.id.buildingInfo);
        textView.setText(string);
    }
}
