package com.cs554.sprint1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModeSelect extends AppCompatActivity {
    boolean on_line,off_line = false;
    Button offline,online;
    TextView modeSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs_select);
        offline = (Button)findViewById(R.id.Offline);
        online = (Button)findViewById(R.id.Online);
        modeSelect = (TextView)findViewById(R.id.ModeSelect);
        Typeface tf;
        tf = Typeface.createFromAsset(getAssets(), "fonts/DIRTYEGO.TTF");
        offline.setTypeface(tf);
        online.setTypeface(tf);
        modeSelect.setTypeface(tf);
    }

    public void goToOnline(View view) {
        Intent newScreen = new Intent(ModeSelect.this, MainActivity.class);
        startActivity(newScreen);
    }
    public void goToOffline(View view) {
        Intent newScreen = new Intent(ModeSelect.this, WelcomeActivity.class);
        startActivity(newScreen);
    }

}
