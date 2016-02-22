package com.cs554.sprint1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

// Changed project name to cs554.sprint1

public class WelcomeActivity extends AppCompatActivity {
    //testcomment
    int num_players, board_size = 0;
    boolean on_line,offline, standard_mode, single = false;
    Button standard,freestyle,tenbyten,fifteenbyfifteen, twentybytwenty, ai, twoplayerlocal, play;
    TextView textView;
    Switch aSwitch;
    Typeface tf;
// Testing check into project repository again

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        play = (Button)findViewById(R.id.play_button);
        standard = (Button)findViewById(R.id.Standard);
        freestyle = (Button)findViewById(R.id.Freestyle);
        tenbyten = (Button)findViewById(R.id.TenByTen);
        fifteenbyfifteen = (Button)findViewById(R.id.FifteenByFifteen);
        twentybytwenty = (Button)findViewById(R.id.TwentyByTwenty);
        ai = (Button)findViewById(R.id.AI);
        twoplayerlocal = (Button)findViewById(R.id.LocalTwoPlayer);
        tf = Typeface.createFromAsset(getAssets(), "fonts/DIRTYEGO.TTF");
        textView = (TextView)findViewById(R.id.textViews);
        standard.setTypeface(tf);
        play.setTypeface(tf);
        freestyle.setTypeface(tf);
        tenbyten.setTypeface(tf);
        fifteenbyfifteen.setTypeface(tf);
        twentybytwenty.setTypeface(tf);
        ai.setTypeface(tf);
        twoplayerlocal.setTypeface(tf);
        //aSwitch = (Switch)findViewById(R.id.ToggleMode);

//        Button play = (Button) findViewById(R.id.play_button);

    }

    //added
    public void SelectNumPlayers (View view)
    {
        boolean players_checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.AI:
                if(players_checked) {
                    single = true;
             //       Toast.makeText(this, "you picked one player mode", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.LocalTwoPlayer:
                if (players_checked)
                {
                    single = false;
                    break;
                }
        }

    }



    public void SelectMode (View view)
    {
        boolean button_checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.Standard:
                if(button_checked) {
                    standard_mode = true;
                    break;
                }
            case R.id.Freestyle:
                if (button_checked)
                {
                    standard_mode = false;
                    break;
                }
        }
    }

    public void SelectSize (View view)
    {
        boolean button_checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.TenByTen:
                if(button_checked) {
                    board_size = 10;
                    break;
                }
            case R.id.FifteenByFifteen:
                if (button_checked)
                {
                    board_size = 15;
                    break;
                }
            case R.id.TwentyByTwenty:
                if (button_checked)
                {
                    board_size = 20;
                    break;
                }
        }
    }

    public void GoToPlayScreen(View view)
    {


        //first task to complete is 2 player offline freestyle
        if (!on_line)
        {
            Intent newScreen = new Intent(WelcomeActivity.this, BoardActivity.class);
            Bundle extras = new Bundle();
            extras.putInt("size", board_size);
            extras.putBoolean("single", single);
            extras.putBoolean("standard_mode", standard_mode);
            extras.putBoolean("on_line", on_line);
            extras.putInt("score1", 0);
            extras.putInt("score2", 0);
            newScreen.putExtras(extras);
            startActivity(newScreen);
        }
        else if(on_line)
        {
            Intent newScreen = new Intent(WelcomeActivity.this, BoardActivity.class);
            Bundle extras = new Bundle();
            extras.putInt("size", board_size);
            extras.putBoolean("single", single);
            extras.putBoolean("standard_mode", standard_mode);
            extras.putBoolean("on_line", on_line);
            extras.putInt("score1", 0);
            extras.putInt("score2", 0);
            newScreen.putExtras(extras);
            startActivity(newScreen);

            //Toast.makeText(this, "This option combo doesn't work yet :(", Toast.LENGTH_LONG).show();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
