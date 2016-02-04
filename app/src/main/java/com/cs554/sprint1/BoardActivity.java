package com.cs554.sprint1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class BoardActivity extends AppCompatActivity {


    int players;
    boolean playingAgainstComputer = true;

    Chronometer timer;

    int player = 0;
    boolean first_game = true;
    int p1_wins, p2_wins = 0;
    int size = 10;

    int board[][] =
            {
                    {R.id.stone00, R.id.stone01, R.id.stone02, R.id.stone03, R.id.stone04, R.id.stone05, R.id.stone06, R.id.stone07, R.id.stone08, R.id.stone09,
                            R.id.stone0a, R.id.stone0b, R.id.stone0c, R.id.stone0d, R.id.stone0e, R.id.stone0f, R.id.stone0g, R.id.stone0h, R.id.stone0i, R.id.stone0j},
                    {R.id.stone10, R.id.stone11, R.id.stone12, R.id.stone13, R.id.stone14, R.id.stone15, R.id.stone16, R.id.stone17, R.id.stone18, R.id.stone19,
                            R.id.stone1a, R.id.stone1b, R.id.stone1c, R.id.stone1d, R.id.stone1e, R.id.stone1f, R.id.stone1g, R.id.stone1h, R.id.stone1i, R.id.stone1j},
                    {R.id.stone20, R.id.stone21, R.id.stone22, R.id.stone23, R.id.stone24, R.id.stone25, R.id.stone26, R.id.stone27, R.id.stone28, R.id.stone29,
                            R.id.stone2a, R.id.stone2b, R.id.stone2c, R.id.stone2d, R.id.stone2e, R.id.stone2f, R.id.stone2g, R.id.stone2h, R.id.stone2i, R.id.stone2j},
                    {R.id.stone30, R.id.stone31, R.id.stone32, R.id.stone33, R.id.stone34, R.id.stone35, R.id.stone36, R.id.stone37, R.id.stone38, R.id.stone39,
                            R.id.stone3a, R.id.stone3b, R.id.stone3c, R.id.stone3d, R.id.stone3e, R.id.stone3f, R.id.stone3g, R.id.stone3h, R.id.stone3i, R.id.stone3j},
                    {R.id.stone40, R.id.stone41, R.id.stone42, R.id.stone43, R.id.stone44, R.id.stone45, R.id.stone46, R.id.stone47, R.id.stone48, R.id.stone49,
                            R.id.stone4a, R.id.stone4b, R.id.stone4c, R.id.stone4d, R.id.stone4e, R.id.stone4f, R.id.stone4g, R.id.stone4h, R.id.stone4i, R.id.stone4j},
                    {R.id.stone50, R.id.stone51, R.id.stone52, R.id.stone53, R.id.stone54, R.id.stone55, R.id.stone56, R.id.stone57, R.id.stone58, R.id.stone59,
                            R.id.stone5a, R.id.stone5b, R.id.stone5c, R.id.stone5d, R.id.stone5e, R.id.stone5f, R.id.stone5g, R.id.stone5h, R.id.stone5i, R.id.stone5j},
                    {R.id.stone60, R.id.stone61, R.id.stone62, R.id.stone63, R.id.stone64, R.id.stone65, R.id.stone66, R.id.stone67, R.id.stone68, R.id.stone69,
                            R.id.stone6a, R.id.stone6b, R.id.stone6c, R.id.stone6d, R.id.stone6e, R.id.stone6f, R.id.stone6g, R.id.stone6h, R.id.stone6i, R.id.stone6j},
                    {R.id.stone70, R.id.stone71, R.id.stone72, R.id.stone73, R.id.stone74, R.id.stone75, R.id.stone76, R.id.stone77, R.id.stone78, R.id.stone79,
                            R.id.stone7a, R.id.stone7b, R.id.stone7c, R.id.stone7d, R.id.stone7e, R.id.stone7f, R.id.stone7g, R.id.stone7h, R.id.stone7i, R.id.stone7j},
                    {R.id.stone80, R.id.stone81, R.id.stone82, R.id.stone83, R.id.stone84, R.id.stone85, R.id.stone86, R.id.stone87, R.id.stone88, R.id.stone89,
                            R.id.stone8a, R.id.stone8b, R.id.stone8c, R.id.stone8d, R.id.stone8e, R.id.stone8f, R.id.stone8g, R.id.stone8h, R.id.stone8i, R.id.stone8j},
                    {R.id.stone90, R.id.stone91, R.id.stone92, R.id.stone93, R.id.stone94, R.id.stone95, R.id.stone96, R.id.stone97, R.id.stone98, R.id.stone99,
                            R.id.stone9a, R.id.stone9b, R.id.stone9c, R.id.stone9d, R.id.stone9e, R.id.stone9f, R.id.stone9g, R.id.stone9h, R.id.stone9i, R.id.stone9j},
                    {R.id.stonea0, R.id.stonea1, R.id.stonea2, R.id.stonea3, R.id.stonea4, R.id.stonea5, R.id.stonea6, R.id.stonea7, R.id.stonea8, R.id.stonea9,
                            R.id.stoneaa, R.id.stoneab, R.id.stoneac, R.id.stonead, R.id.stoneae, R.id.stoneaf, R.id.stoneag, R.id.stoneah, R.id.stoneai, R.id.stoneaj},
                    {R.id.stoneb0, R.id.stoneb1, R.id.stoneb2, R.id.stoneb3, R.id.stoneb4, R.id.stoneb5, R.id.stoneb6, R.id.stoneb7, R.id.stoneb8, R.id.stoneb9,
                            R.id.stoneba, R.id.stonebb, R.id.stonebc, R.id.stonebd, R.id.stonebe, R.id.stonebf, R.id.stonebg, R.id.stonebh, R.id.stonebi, R.id.stonebj},
                    {R.id.stonec0, R.id.stonec1, R.id.stonec2, R.id.stonec3, R.id.stonec4, R.id.stonec5, R.id.stonec6, R.id.stonec7, R.id.stonec8, R.id.stonec9,
                            R.id.stoneca, R.id.stonecb, R.id.stonecc, R.id.stonecd, R.id.stonece, R.id.stonecf, R.id.stonecg, R.id.stonech, R.id.stoneci, R.id.stonecj},
                    {R.id.stoned0, R.id.stoned1, R.id.stoned2, R.id.stoned3, R.id.stoned4, R.id.stoned5, R.id.stoned6, R.id.stoned7, R.id.stoned8, R.id.stoned9,
                            R.id.stoneda, R.id.stonedb, R.id.stonedc, R.id.stonedd, R.id.stonede, R.id.stonedf, R.id.stonedg, R.id.stonedh, R.id.stonedi, R.id.stonedj},
                    {R.id.stonee0, R.id.stonee1, R.id.stonee2, R.id.stonee3, R.id.stonee4, R.id.stonee5, R.id.stonee6, R.id.stonee7, R.id.stonee8, R.id.stonee9,
                            R.id.stoneea, R.id.stoneeb, R.id.stoneec, R.id.stoneed, R.id.stoneee, R.id.stoneef, R.id.stoneeg, R.id.stoneeh, R.id.stoneei, R.id.stoneej},
                    {R.id.stonef0, R.id.stonef1, R.id.stonef2, R.id.stonef3, R.id.stonef4, R.id.stonef5, R.id.stonef6, R.id.stonef7, R.id.stonef8, R.id.stonef9,
                            R.id.stonefa, R.id.stonefb, R.id.stonefc, R.id.stonefd, R.id.stonefe, R.id.stoneff, R.id.stonefg, R.id.stonefh, R.id.stonefi, R.id.stonefj},
                    {R.id.stoneg0, R.id.stoneg1, R.id.stoneg2, R.id.stoneg3, R.id.stoneg4, R.id.stoneg5, R.id.stoneg6, R.id.stoneg7, R.id.stoneg8, R.id.stoneg9,
                            R.id.stonega, R.id.stonegb, R.id.stonegc, R.id.stonegd, R.id.stonege, R.id.stonegf, R.id.stonegg, R.id.stonegh, R.id.stonegi, R.id.stonegj},
                    {R.id.stoneh0, R.id.stoneh1, R.id.stoneh2, R.id.stoneh3, R.id.stoneh4, R.id.stoneh5, R.id.stoneh6, R.id.stoneh7, R.id.stoneh8, R.id.stoneh9,
                            R.id.stoneha, R.id.stonehb, R.id.stonehc, R.id.stonehd, R.id.stonehe, R.id.stonehf, R.id.stonehg, R.id.stonehh, R.id.stonehi, R.id.stonehj},
                    {R.id.stonei0, R.id.stonei1, R.id.stonei2, R.id.stonei3, R.id.stonei4, R.id.stonei5, R.id.stonei6, R.id.stonei7, R.id.stonei8, R.id.stonei9,
                            R.id.stoneia, R.id.stoneib, R.id.stoneic, R.id.stoneid, R.id.stoneie, R.id.stoneif, R.id.stoneig, R.id.stoneih, R.id.stoneii, R.id.stoneij},
                    {R.id.stonej0, R.id.stonej1, R.id.stonej2, R.id.stonej3, R.id.stonej4, R.id.stonej5, R.id.stonej6, R.id.stonej7, R.id.stonej8, R.id.stonej9,
                            R.id.stoneja, R.id.stonejb, R.id.stonejc, R.id.stonejd, R.id.stoneje, R.id.stonejf, R.id.stonejg, R.id.stonejh, R.id.stoneji, R.id.stonejj}
            };
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        //set the timer variable
        timer = (Chronometer) findViewById(R.id.timer_display);

        Intent passed = getIntent();

        size = passed.getExtras().getInt("size");
        players = passed.getExtras().getInt("players");
        playingAgainstComputer = (players == 1);

        //if the size is 15, show the 15X15 buttons
        //if size is 20, show all buttons
        //10X10 is default
        if (size > 10) {
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    (findViewById(board[i][j])).setVisibility(View.VISIBLE);
                }
            }
        }

        if (size > 15) {
            for (int i = 15; i < 20; i++) {
                for (int j = 15; j < 20; j++) {
                    (findViewById(board[i][j])).setVisibility(View.VISIBLE);
                }
            }
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

    public void onButtonClicked(View view) {

        if (gameOver) return;

        Button stone = (Button) view;
        TextView winner_text = (TextView) findViewById(R.id.winner_text);
        Button rematch_button = (Button) findViewById(R.id.rematch_button);
        System.out.println("Button clicked");

        if (stone.getText().toString().compareTo(" ") == 0) {
            {
                if (player == 0) {
                    player = 1;
                    ((TextView) findViewById(R.id.player_turn_text)).setText(" " +
                            "Player 2's Turn");
                    stone.setBackgroundResource(R.drawable.black_board);
                    stone.setTextColor(0);
                    stone.setText("G");

                    if (playingAgainstComputer) {
                        System.out.println("Computer thinking");
                        Move computerMove = bestmove("R", makeboard(board), 4);
                        System.out.println("Computer says: " + computerMove.i + " " + computerMove.j);
                        onButtonClicked(findViewById(board[computerMove.i][computerMove.j]));
                    }

                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.start();

                } else {
                    player = 0;
                    ((TextView) findViewById(R.id.player_turn_text)).setText(" " +
                            "Player 1's Turn");
                    stone.setBackgroundResource(R.drawable.white_board);
                    stone.setTextColor(Color.rgb(255, 255, 255));
                    stone.setText("R");
                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.start();
                }
            }

            if (analyzer("G", makeboard(board))) {
                System.out.println("GREEN WINS!");
                p1_wins++;
                ((TextView) findViewById(R.id.scores_text)).setText(
                        "Player 1: " + p1_wins + "    Player 2: " + p2_wins);
                winner_text.setText(
                        "Player 1 Wins");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;

            } else if (analyzer("R", makeboard(board))) {
                System.out.println("RED WINS!");
                p2_wins++;
                ((TextView) findViewById(R.id.scores_text)).setText(
                        "Player 1: " + p1_wins + "    Player 2: " + p2_wins);
                winner_text.setText(
                        "Player 2 Wins");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;
            }


        }
    }

    public void resetGame(View view) {
        player = 0;
        gameOver = false;
        setContentView(R.layout.activity_board);
        ((TextView) findViewById(R.id.scores_text)).setText(
                "Player 1: " + p1_wins + "    Player 2: " + p2_wins);
    }

    public boolean analyzer(String s, String[][] board) {
        String ji;
        String jmini, jmin2i, jminimin2;
        String jplusi, jplus2i, jplus2imin;
        String jimin, jimin2;
        String jiplus, jiplus2, jmin2imin;
        String jminimin, jmin2imin2, jmin2iplus;
        String jplusiplus, jplus2iplus2;
        String jminiplus, jmin2iplus2;
        String jplusimin, jplus2imin2;

        for (int j = 2; j < 18; j++)
            for (int i = 2; i < 18; i++) {
                ji = board[j][i];
                jmini = board[j - 1][i];
                jplusi = board[j + 1][i];
                jimin = board[j][i - 1];
                jiplus = board[j][i + 1];
                jminimin = board[j - 1][i - 1];
                jplusiplus = board[j + 1][i + 1];
                jminiplus = board[j - 1][i + 1];
                jplusimin = board[j + 1][i - 1];
                jmin2i = board[j - 2][i];
                jplus2i = board[j + 2][i];
                jimin2 = board[j][i - 2];
                jiplus2 = board[j][i + 2];
                jplus2iplus2 = board[j + 2][i + 2];
                jmin2iplus2 = board[j - 2][i + 2];
                jplus2imin2 = board[j + 2][i - 2];
                jmin2imin2 = board[j - 2][i - 2];
                jmin2imin = board[j - 2][i - 1];
                jmin2iplus = board[j - 2][i + 1];
                jminimin2 = board[j - 1][i - 2];
                String jminiplus2 = board[j - 1][i + 2];
                String jplusimin2 = board[j + 1][i - 2];
                String jplus2iplus = board[j + 2][i + 1];
                String jplusiplus2 = board[j + 1][i + 2];
                jplus2imin = board[j + 2][i - 1];

                if
                        (((ji.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jmin2imin2.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0))
                        || ((jminimin.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0))
                        || ((jplusimin.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0) && (jplusimin2.compareTo(s) == 0))
                        || ((jplus2imin.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0) && (jmin2iplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0) && (jmin2imin2.compareTo(s) == 0))
                        || ((jmin2imin2.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0) && (jplusimin2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0))
                        || ((jmin2iplus2.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jplus2imin.compareTo(s) == 0))
                        || ((jmin2iplus.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0))

                        ) {
                    return true;
                }
            }
        return false;
    }

    public int analyzer5(String s, String[][] board) {
        String ji;
        String jmini, jmin2i, jminimin2;
        String jplusi, jplus2i, jplus2imin;
        String jimin, jimin2;
        String jiplus, jiplus2, jmin2imin;
        String jminimin, jmin2imin2, jmin2iplus;
        String jplusiplus, jplus2iplus2;
        String jminiplus, jmin2iplus2;
        String jplusimin, jplus2imin2;
        int cnt = 0;
        for (int j = 2; j < 18; j++)
            for (int i = 2; i < 18; i++) {
                ji = board[j][i];
                jmini = board[j - 1][i];
                jplusi = board[j + 1][i];
                jimin = board[j][i - 1];
                jiplus = board[j][i + 1];
                jminimin = board[j - 1][i - 1];
                jplusiplus = board[j + 1][i + 1];
                jminiplus = board[j - 1][i + 1];
                jplusimin = board[j + 1][i - 1];
                jmin2i = board[j - 2][i];
                jplus2i = board[j + 2][i];
                jimin2 = board[j][i - 2];
                jiplus2 = board[j][i + 2];
                jplus2iplus2 = board[j + 2][i + 2];
                jmin2iplus2 = board[j - 2][i + 2];
                jplus2imin2 = board[j + 2][i - 2];
                jmin2imin2 = board[j - 2][i - 2];
                jmin2imin = board[j - 2][i - 1];
                jmin2iplus = board[j - 2][i + 1];
                jminimin2 = board[j - 1][i - 2];
                String jminiplus2 = board[j - 1][i + 2];
                String jplusimin2 = board[j + 1][i - 2];
                String jplus2iplus = board[j + 2][i + 1];
                String jplusiplus2 = board[j + 1][i + 2];
                jplus2imin = board[j + 2][i - 1];

                if
                        (((ji.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jmin2imin2.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0))
                        || ((jminimin.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0))
                        || ((jplusimin.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0) && (jplusimin2.compareTo(s) == 0))
                        || ((jplus2imin.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0) && (jmin2iplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0) && (jmin2imin2.compareTo(s) == 0))
                        || ((jmin2imin2.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0) && (jplusimin2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0))
                        || ((jmin2iplus2.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jplus2imin.compareTo(s) == 0))
                        || ((jmin2iplus.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0))

                        ) {
                    cnt++;
                }
            }
        return cnt;
    }

    public int analyzer4(String s, String[][] board) {
        String ji;
        String jmini, jmin2i, jminimin2;
        String jplusi, jplus2i, jplus2imin;
        String jimin, jimin2;
        String jiplus, jiplus2, jmin2imin;
        String jminimin, jmin2imin2, jmin2iplus;
        String jplusiplus, jplus2iplus2;
        String jminiplus, jmin2iplus2;
        String jplusimin, jplus2imin2;
        int cnt = 0;
        for (int j = 2; j < 18; j++)
            for (int i = 2; i < 18; i++) {
                ji = board[j][i];
                jmini = board[j - 1][i];
                jplusi = board[j + 1][i];
                jimin = board[j][i - 1];
                jiplus = board[j][i + 1];
                jminimin = board[j - 1][i - 1];
                jplusiplus = board[j + 1][i + 1];
                jminiplus = board[j - 1][i + 1];
                jplusimin = board[j + 1][i - 1];
                jmin2i = board[j - 2][i];
                jplus2i = board[j + 2][i];
                jimin2 = board[j][i - 2];
                jiplus2 = board[j][i + 2];
                jplus2iplus2 = board[j + 2][i + 2];
                jmin2iplus2 = board[j - 2][i + 2];
                jplus2imin2 = board[j + 2][i - 2];
                jmin2imin2 = board[j - 2][i - 2];
                jmin2imin = board[j - 2][i - 1];
                jmin2iplus = board[j - 2][i + 1];
                jminimin2 = board[j - 1][i - 2];
                String jminiplus2 = board[j - 1][i + 2];
                String jplusimin2 = board[j + 1][i - 2];
                String jplus2iplus = board[j + 2][i + 1];
                String jplusiplus2 = board[j + 1][i + 2];
                jplus2imin = board[j + 2][i - 1];

                if
                        (((ji.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jmin2imin2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jimin2.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0))
                        || ((jminimin.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0))
                        || ((jplusimin.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0))
                        || ((jplus2imin.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0) && (jmin2iplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0))
                        || ((jmin2imin2.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0) && (jplusimin2.compareTo(s) == 0))
                        || ((jmin2iplus2.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0))
                        || ((jmin2iplus.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0))

                        ) {
                    cnt++;
                }
            }
        return cnt;
    }

    public int analyzer3(String s, String[][] board) {
        String ji;
        String jmini, jmin2i, jminimin2;
        String jplusi, jplus2i, jplus2imin;
        String jimin, jimin2;
        String jiplus, jiplus2, jmin2imin;
        String jminimin, jmin2imin2, jmin2iplus;
        String jplusiplus, jplus2iplus2;
        String jminiplus, jmin2iplus2;
        String jplusimin, jplus2imin2;
        int cnt = 0;
        for (int j = 2; j < 18; j++)
            for (int i = 2; i < 18; i++) {
                ji = board[j][i];
                jmini = board[j - 1][i];
                jplusi = board[j + 1][i];
                jimin = board[j][i - 1];
                jiplus = board[j][i + 1];
                jminimin = board[j - 1][i - 1];
                jplusiplus = board[j + 1][i + 1];
                jminiplus = board[j - 1][i + 1];
                jplusimin = board[j + 1][i - 1];
                jmin2i = board[j - 2][i];
                jplus2i = board[j + 2][i];
                jimin2 = board[j][i - 2];
                jiplus2 = board[j][i + 2];
                jplus2iplus2 = board[j + 2][i + 2];
                jmin2iplus2 = board[j - 2][i + 2];
                jplus2imin2 = board[j + 2][i - 2];
                jmin2imin2 = board[j - 2][i - 2];
                jmin2imin = board[j - 2][i - 1];
                jmin2iplus = board[j - 2][i + 1];
                jminimin2 = board[j - 1][i - 2];
                String jminiplus2 = board[j - 1][i + 2];
                String jplusimin2 = board[j + 1][i - 2];
                String jplus2iplus = board[j + 2][i + 1];
                String jplusiplus2 = board[j + 1][i + 2];
                jplus2imin = board[j + 2][i - 1];

                if
                        (((ji.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jiplus.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jplusi.compareTo(s) == 0))
                        || ((jminimin.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0))
                        || ((jplusimin.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0))
                        || ((jplus2imin.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0) && (jmin2iplus.compareTo(s) == 0))
                        || ((jmin2imin2.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0))
                        || ((jmin2iplus2.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jimin.compareTo(s) == 0))
                        || ((jmin2iplus.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jiplus.compareTo(s) == 0))

                        ) {
                    cnt++;
                }
            }
        return cnt;
    }

    public int analyzer2(String s, String[][] board) {
        String ji;
        String jmini, jmin2i, jminimin2;
        String jplusi, jplus2i, jplus2imin;
        String jimin, jimin2;
        String jiplus, jiplus2, jmin2imin;
        String jminimin, jmin2imin2, jmin2iplus;
        String jplusiplus, jplus2iplus2;
        String jminiplus, jmin2iplus2;
        String jplusimin, jplus2imin2;
        int cnt = 0;
        for (int j = 2; j < 18; j++)
            for (int i = 2; i < 18; i++) {
                ji = board[j][i];
                jmini = board[j - 1][i];
                jplusi = board[j + 1][i];
                jimin = board[j][i - 1];
                jiplus = board[j][i + 1];
                jminimin = board[j - 1][i - 1];
                jplusiplus = board[j + 1][i + 1];
                jminiplus = board[j - 1][i + 1];
                jplusimin = board[j + 1][i - 1];
                jmin2i = board[j - 2][i];
                jplus2i = board[j + 2][i];
                jimin2 = board[j][i - 2];
                jiplus2 = board[j][i + 2];
                jplus2iplus2 = board[j + 2][i + 2];
                jmin2iplus2 = board[j - 2][i + 2];
                jplus2imin2 = board[j + 2][i - 2];
                jmin2imin2 = board[j - 2][i - 2];
                jmin2imin = board[j - 2][i - 1];
                jmin2iplus = board[j - 2][i + 1];
                jminimin2 = board[j - 1][i - 2];
                String jminiplus2 = board[j - 1][i + 2];
                String jplusimin2 = board[j + 1][i - 2];
                String jplus2iplus = board[j + 2][i + 1];
                String jplusiplus2 = board[j + 1][i + 2];
                jplus2imin = board[j + 2][i - 1];

                if
                        (((ji.compareTo(s) == 0) && (jminimin.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jimin.compareTo(s) == 0))
                        || ((ji.compareTo(s) == 0) && (jmini.compareTo(s) == 0))
                        || ((jminimin.compareTo(s) == 0) && (jmini.compareTo(s) == 0))
                        || ((jplusimin.compareTo(s) == 0) && (jplusi.compareTo(s) == 0))
                        || ((jplus2imin.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0))
                        || ((jmin2imin2.compareTo(s) == 0) && (jimin2.compareTo(s) == 0))
                        || ((jmin2iplus2.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0))
                        || ((jmin2imin.compareTo(s) == 0) && (jminimin.compareTo(s) == 0))
                        || ((jmin2iplus.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0))

                        ) {
                    cnt++;
                }
            }
        return cnt;
    }


    public String[][] makeboard(int[][] board) {
        String[][] stoneBoard = new String[20][20];
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++) {
                stoneBoard[i][j] = String.valueOf(((Button) findViewById(board[i][j])).getText());
                if (stoneBoard[i][j].compareTo("") == 0) stoneBoard[i][j] = " ";
            }
        return stoneBoard;
    }

    public Move bestmove(String s, String board[][], int depth) {
        Move move, worstMove;
        Move bestMove = new Move(0, 0, 0);
        String[][] thisBoard = board;
        String otherStone = (s.compareTo("G") == 0) ? "R" : "G";
        int oldWorth, moveWorth;

        for (int i = 0; i < size; i++)
            System.out.println(Arrays.toString(thisBoard[i]));

        // make winning move
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    thisBoard[i][j] = s;
                    if (analyzer5(s, thisBoard) > 0) {
                        System.out.println(s + " found winning move 5" + i + " " + j);
                        bestMove = new Move(i, j, 1);
                        thisBoard[i][j] = " ";
                        return bestMove;
                    } else thisBoard[i][j] = " ";
                }
            }

        // block opponent's winning move
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {

                    thisBoard[i][j] = otherStone;
                    if (analyzer5(otherStone, thisBoard) > 0) {
                        System.out.println(s + " blocked winning move 5" + i + " " + j);
                        bestMove = new Move(i, j, 0);
                        thisBoard[i][j] = " ";
                        return bestMove;
                    } else thisBoard[i][j] = " ";
                }
            }

        // increase 4 sequence by as much as possible with this move
        int fourStones = analyzer4(s, thisBoard);
        oldWorth = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    thisBoard[i][j] = s;
                    if ((moveWorth = analyzer4(s, thisBoard) - fourStones) > oldWorth) {
                        oldWorth = moveWorth;
                        bestMove = new Move(i, j, moveWorth);
                        thisBoard[i][j] = " ";
                    } else thisBoard[i][j] = " ";
                }
            }
        if (oldWorth > 0) {
            System.out.println(s + " found best 4 move" + bestMove.i + " " + bestMove.j);
            return bestMove;
        }

        // block as many 4 sequences as possible with this move
        fourStones = analyzer4(otherStone, thisBoard);
        oldWorth = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    thisBoard[i][j] = otherStone;
                    if ((moveWorth = analyzer4(otherStone, thisBoard) - fourStones) > oldWorth) {
                        oldWorth = moveWorth;
                        bestMove = new Move(i, j, moveWorth);
                        thisBoard[i][j] = " ";
                    } else thisBoard[i][j] = " ";
                }
            }
        if (oldWorth > 0) {
            System.out.println(s + " blocked best 4 move" + bestMove.i + " " + bestMove.j);
            return bestMove;
        }

        // increase 3 sequence by as much as possible with this move
        int threeStones = analyzer3(s, thisBoard);
        oldWorth = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    thisBoard[i][j] = s;
                    if ((moveWorth = analyzer3(s, thisBoard) - threeStones) > oldWorth) {
                        oldWorth = moveWorth;
                        bestMove = new Move(i, j, moveWorth);
                        thisBoard[i][j] = " ";
                    } else thisBoard[i][j] = " ";
                }
            }
        if (oldWorth > 0) {
            System.out.println(s + " found best 3 move" + bestMove.i + " " + bestMove.j);
            return bestMove;
        }

        // block as many 3 sequences as possible with this move
        threeStones = analyzer3(otherStone, thisBoard);
        oldWorth = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    thisBoard[i][j] = otherStone;
                    if ((moveWorth = analyzer3(otherStone, thisBoard) - threeStones) > oldWorth) {
                        oldWorth = moveWorth;
                        bestMove = new Move(i, j, moveWorth);
                        thisBoard[i][j] = " ";
                    } else thisBoard[i][j] = " ";
                }
            }
        if (oldWorth > 0) {
            System.out.println(s + " blocked best 3 move" + bestMove.i + " " + bestMove.j);
            return bestMove;
        }


        // make as many 2 sequences as possible with this move
        int twoStones = analyzer2(otherStone, thisBoard);
        oldWorth = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    thisBoard[i][j] = s;
                    if ((moveWorth = analyzer2(s, thisBoard) - twoStones) > oldWorth) {
                        oldWorth = moveWorth;
                        bestMove = new Move(i, j, moveWorth);
                        thisBoard[i][j] = " ";
                    } else thisBoard[i][j] = " ";
                }
            }
        if (oldWorth > 0) {
            System.out.println(s + " found best 2 move" + bestMove.i + " " + bestMove.j);
            return bestMove;
        }

        // block as many 2 sequences as possible with this move
        twoStones = analyzer2(otherStone, thisBoard);
        oldWorth = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    thisBoard[i][j] = otherStone;
                    if ((moveWorth = analyzer2(otherStone, thisBoard) - twoStones) > oldWorth) {
                        oldWorth = moveWorth;
                        bestMove = new Move(i, j, moveWorth);
                        thisBoard[i][j] = " ";
                    } else thisBoard[i][j] = " ";
                }
            }
        if (oldWorth > 0) {
            System.out.println(s + " blocked best 2 move" + bestMove.i + " " + bestMove.j);
            return bestMove;
        }

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    System.out.println(s + " first valid move" + i + " " + j);
                    bestMove = new Move(i, j, 0);
                    return bestMove;
                }
            }
        return bestMove;
    }
}
/*
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                if (thisBoard[i][j].compareTo(" ") == 0) {
                    bestMove = new Move(i, j, 0);
                    thisBoard[i][j] = s;
                    //          if (depth > 0)
                    {
                        System.out.println(otherStone + " recursing " + i + " " + j);
                        worstMove = bestmove(otherStone, thisBoard, depth);
                        if (worstMove.getVal() < 1)  {//>= bestMove.getVal()) {
                            System.out.println(otherStone + " returning worst move " + i + " " + j);
                            thisBoard[i][j] = " ";
                            return bestMove;
                        }
                    } /* else {
                        System.out.println(otherStone + " depth expired " + i + " " + j);
                        thisBoard[i][j] = " ";
                        return bestMove;
                    }
                    thisBoard[i][j] = " ";
                }
            }
        System.out.println(otherStone + " default move " + bestMove.i + " " + bestMove.j);
        return bestMove;

    }
}
*/
