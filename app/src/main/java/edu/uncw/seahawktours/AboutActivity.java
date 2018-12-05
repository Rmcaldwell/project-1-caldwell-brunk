package edu.uncw.seahawktours;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;


public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(null);

        TextView textview = (TextView) findViewById(R.id.aboutStringID2);

        textview.setMovementMethod(LinkMovementMethod.getInstance());
//
//        String text = "UNCW building information and images courtesy of the UNCW University Archives.";
//
//        SpannableString ss = new SpannableString(text);


//        ClickableSpan clickableSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//                Toast.makeText(AboutActivity.this, "One", Toast.LENGTH_SHORT);
//
//            }
//            @Override
//            public void updateDrawState(TextPaint ds) {
//                super.updateDrawState(ds);
//                ds.setColor(Color.BLUE);
//                ds.setUnderlineText(false);
//            }
//        };
//
//        ss.setSpan(clickableSpan, 53, 77, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        textview.setText(ss);
//        textview.setMovementMethod(LinkMovementMethod.getInstance());

    }

//    @Override
//    public boolean onCreateOptionsMenu (Menu menu) {
//        //Inflate the menu; this adds items to the app bar
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    public boolean onOptionsItemSelected (MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_info:
//                Intent intent = new Intent (this, MainActivity.class);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}
