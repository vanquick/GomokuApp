package com.cs554.sprint1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //get the screen size so that we can size the text
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;

        // Get the screen's density scale
        float scale = getResources().getDisplayMetrics().density;

        //get cool typeface for the Gomoku title
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/DIRTYEGO.TTF");

        TextView main_title = (TextView) findViewById(R.id.main_title_text);
        main_title.setTypeface(tf);
        main_title.setTextSize((int) (.4 * (screenWidth / scale)));

        Button play_button = (Button) findViewById(R.id.play_button);
        play_button.setTypeface(tf);
        play_button.setTextSize((int) (.15 * (screenWidth / scale)));

        ((TextView)findViewById(R.id.name_ss)).setTextSize((int) (.02 * (screenWidth/scale)));
        ((TextView)findViewById(R.id.name_tv)).setTextSize((int) (.02 * (screenWidth/scale)));
        ((TextView)findViewById(R.id.name_jv)).setTextSize((int) (.02 * (screenWidth/scale)));

//        Toast.makeText(this, "height "+ screenHeight, Toast.LENGTH_LONG).show();

    }

    public void play_game(View view) {
        Intent newScreen = new Intent(Splash.this, WelcomeActivity.class);
        startActivity(newScreen);

    }
}
