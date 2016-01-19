package com.hfad.board;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    int player = 0;
    int board[][] = {
            {R.id.stone00, R.id.stone01, R.id.stone02, R.id.stone03, R.id.stone04, R.id.stone05, R.id.stone06, R.id.stone07, R.id.stone08, R.id.stone09},
            {R.id.stone10, R.id.stone11, R.id.stone12, R.id.stone13, R.id.stone14, R.id.stone15, R.id.stone16, R.id.stone17, R.id.stone18, R.id.stone19},
            {R.id.stone20, R.id.stone21, R.id.stone22, R.id.stone23, R.id.stone24, R.id.stone25, R.id.stone26, R.id.stone27, R.id.stone28, R.id.stone29},
            {R.id.stone30, R.id.stone31, R.id.stone32, R.id.stone33, R.id.stone34, R.id.stone35, R.id.stone36, R.id.stone37, R.id.stone38, R.id.stone39},
            {R.id.stone40, R.id.stone41, R.id.stone42, R.id.stone43, R.id.stone44, R.id.stone45, R.id.stone46, R.id.stone47, R.id.stone48, R.id.stone49},
            {R.id.stone50, R.id.stone51, R.id.stone52, R.id.stone53, R.id.stone54, R.id.stone55, R.id.stone56, R.id.stone57, R.id.stone58, R.id.stone59},
            {R.id.stone60, R.id.stone61, R.id.stone62, R.id.stone63, R.id.stone64, R.id.stone65, R.id.stone66, R.id.stone67, R.id.stone68, R.id.stone69},
            {R.id.stone70, R.id.stone71, R.id.stone72, R.id.stone73, R.id.stone74, R.id.stone75, R.id.stone76, R.id.stone77, R.id.stone78, R.id.stone79},
            {R.id.stone80, R.id.stone81, R.id.stone82, R.id.stone83, R.id.stone84, R.id.stone85, R.id.stone86, R.id.stone87, R.id.stone88, R.id.stone89},
            {R.id.stone90, R.id.stone91, R.id.stone92, R.id.stone93, R.id.stone94, R.id.stone95, R.id.stone96, R.id.stone97, R.id.stone98, R.id.stone99},
    };
    boolean gameOver = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onButtonClicked(View view) {

        if (gameOver) return;

        Button stone = (Button) view;
        System.out.println("Button clicked");

        if (stone.getText().toString().compareTo("X") == 0) {
            {
                if (player == 0) {
                    stone.setBackgroundColor(Color.RED);
                    player = 1;
                    (findViewById(R.id.turnButton)).setBackgroundColor(Color.GREEN);
                    stone.setText("R");
                } else {
                    stone.setBackgroundColor(Color.GREEN);
                    player = 0;
                    (findViewById(R.id.turnButton)).setBackgroundColor(Color.RED);
                    stone.setText("G");
                }
            }

            for (int i = 0; i < 8; i++)
                System.out.println(Arrays.toString(board[i]));

            if (analyze("G")) {
                System.out.println("GREEN WINS!");
                (findViewById(R.id.winButton)).setBackgroundColor(Color.GREEN);
                gameOver = true;
            } else if (analyze("R")) {
                System.out.println("RED WINS!");
                (findViewById(R.id.winButton)).setBackgroundColor(Color.RED);
                gameOver = true;
            }
        }
    }

    public void resetGame(View view) {
        player = 0;
        gameOver = false;
        setContentView(R.layout.activity_main);
    }

    public boolean analyze(String s) {
        String ji, jmini, jplusi, jimin, jiplus, jminimin, jplusiplus, jminiplus, jplusimin;
        for (int j = 1; j < 9; j++)
            for (int i = 1; i < 9; i++) {
                ji = String.valueOf(((Button) findViewById(board[j][i])).getText());
                jmini = String.valueOf(((Button) findViewById(board[j - 1][i])).getText());
                jplusi = String.valueOf(((Button) findViewById(board[j + 1][i])).getText());
                jimin = String.valueOf(((Button) findViewById(board[j][i - 1])).getText());
                jiplus = String.valueOf(((Button) findViewById(board[j][i + 1])).getText());
                jminimin = String.valueOf(((Button) findViewById(board[j - 1][i - 1])).getText());
                jplusiplus = String.valueOf(((Button) findViewById(board[j + 1][i + 1])).getText());
                jminiplus = String.valueOf(((Button) findViewById(board[j - 1][i + 1])).getText());
                jplusimin = String.valueOf(((Button) findViewById(board[j + 1][i - 1])).getText());
                if
                        (((ji.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jiplus.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jplusi.compareTo(s) == 0))
                        ) return true;
            }
        return false;
    }

}
