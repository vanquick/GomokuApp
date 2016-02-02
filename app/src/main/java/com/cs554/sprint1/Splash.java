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

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
/*
        //get the screen size so that we can size the text
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int stageWidth = displaymetrics.widthPixels;
        int stageHeight = displaymetrics.heightPixels;
*/
        //get cool typeface for the Gomoku title
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/DIRTYEGO.TTF");

        //set font
        TextView main_title = (TextView) findViewById(R.id.main_title_text);
        main_title.setTypeface(tf);
        Button play_button = (Button) findViewById(R.id.play_button);
        play_button.setTypeface(tf);

    }

    public void play_game(View view) {
        Intent newScreen = new Intent(Splash.this, WelcomeActivity.class);
        startActivity(newScreen);

    }
}
