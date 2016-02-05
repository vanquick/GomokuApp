package com.cs554.sprint1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

// Changed project name to cs554.sprint1

public class WelcomeActivity extends AppCompatActivity {
    //testcomment
    int num_players, board_size = 0;
    boolean on_line, standard_mode, single = false;

// Testing check into project repository again

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        Button play = (Button) findViewById(R.id.play_button);

    }

    //added
    public void SelectNumPlayers (View view)
    {
        boolean players_checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.one_player_radio:
                if(players_checked) {
                    single = true;
             //       Toast.makeText(this, "you picked one player mode", Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.two_player_radio:
                if (players_checked)
                {
                    single = false;
                    break;
                }
        }

    }

    public void SelectOnLine (View view)
    {
        boolean button_checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.on_line_radio:
                if(button_checked) {
                    on_line = true;
                    break;
                }
            case R.id.off_line_radio:
                if (button_checked)
                {
                    on_line = false;
                    break;
                }
        }
    }

    public void SelectMode (View view)
    {
        boolean button_checked = ((RadioButton) view).isChecked();

        switch (view.getId())
        {
            case R.id.standard_radio:
                if(button_checked) {
                    standard_mode = true;
                    break;
                }
            case R.id.freestyle_radio:
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
            case R.id.ten_radio:
                if(button_checked) {
                    board_size = 10;
                    break;
                }
            case R.id.fifteen_radio:
                if (button_checked)
                {
                    board_size = 15;
                    break;
                }
            case R.id.twenty_radio:
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
        else
        {
            Toast.makeText(this, "This option combo doesn't work yet :(", Toast.LENGTH_LONG).show();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
