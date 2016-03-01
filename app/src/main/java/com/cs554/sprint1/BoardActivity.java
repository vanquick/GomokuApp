package com.cs554.sprint1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridLayout;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity {


    int players;

    Chronometer timer;
    TextView player_turn, scores, winner_text, menu;
    Button rematch_button;
    Typeface tf;
    int player, game= 0;
    boolean standard, on_line, mult_device, single = false;
    int p1_wins, p2_wins = 0;
    int filled, curr = 0;
    int size = 0;
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

        //get the screen size so that we can size the text
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;

        // Get the screen's density scale
        float scale = getResources().getDisplayMetrics().density;

        //set the timer variable
        timer = (Chronometer) findViewById(R.id.timer_display);
        player_turn = (TextView)findViewById(R.id.player_turn_text);
        scores = (TextView)findViewById(R.id.scores_text);
        rematch_button = (Button)findViewById(R.id.rematch_button);
        winner_text = (TextView)findViewById(R.id.winner_text);
        menu = (TextView)findViewById(R.id.exit_button);

        Intent passed = getIntent();
        size = passed.getExtras().getInt("size");
        single = passed.getExtras().getBoolean("single");
        standard = passed.getExtras().getBoolean("standard_mode");
        on_line = passed.getExtras().getBoolean("on_line");
        p1_wins = passed.getExtras().getInt("score1");
        p2_wins = passed.getExtras().getInt("score2");
        size = passed.getExtras().getInt("size");
        players = passed.getExtras().getInt("players");
        filled = size * size;

        //set scores
        scores.setText("Player1: "+ p1_wins + "    Player2: "+ p2_wins);
     //   winner_text.setText("Playing");


        //get cool typeface for the Gomoku title
        tf = Typeface.createFromAsset(getAssets(), "fonts/DIRTYEGO.TTF");
        timer.setTypeface(tf);
        player_turn.setTypeface(tf);
        scores.setTypeface(tf);
        rematch_button.setTypeface(tf);
        winner_text.setTypeface(tf);
        menu.setTypeface(tf);


        //set sizes of the text fields
        timer.setTextSize((int)(.13 * (screenWidth/scale)));
        player_turn.setTextSize((int)(.13 * (screenWidth/scale)));
        scores.setTextSize((int) (.13 * (screenWidth/scale)));
        rematch_button.setTextSize((int)(.1 * (screenWidth/scale)));
        menu.setTextSize((int) (.1 * (screenWidth/scale)));
        winner_text.setTextSize((int)(.13 * (screenWidth/scale)));


        //if the size is 15, show the 15X15 buttons
        //if size is 20, show all buttons
        //10X10 is default
        if (size == 10){
            GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
            grid.setPadding(0,(int)(.03 * (screenHeight)), 0, (int)(.03 * (screenHeight)));
            for (int i = 0; i < 10; i++){
                for (int j = 0; j < 10; j++) {
                    Button button = (Button) (findViewById(board[i][j]));
                    ViewGroup.LayoutParams params = button.getLayoutParams();
                    params.width = params.height = (int)(.05 * (screenHeight));
                    button.setLayoutParams(params);
                }
            }
        }
        if (size == 15) {
            GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
            grid.setPadding(0,(int)(.01 * (screenHeight)), 0, 0);
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    Button button = (Button) (findViewById(board[i][j]));
                    button.setVisibility(View.VISIBLE);
                    ViewGroup.LayoutParams params = button.getLayoutParams();
                    params.width = params.height = (int)(.035 * (screenHeight));
                    button.setLayoutParams(params);
                }
            }
        }
        if (size > 15) {
            GridLayout grid = (GridLayout)(findViewById(R.id.button_layout));
            grid.setPadding(0,(int)(.01 * (screenHeight)), 0, 0);
             for (int i = 0; i < 20; i++) {
                 for (int j = 0; j < 20; j++) {
                     Button button = (Button) (findViewById(board[i][j]));
                     button.setVisibility(View.VISIBLE);
                     ViewGroup.LayoutParams params = button.getLayoutParams();
                     params.width = params.height = (int)(.027 * (screenHeight));
                     button.setLayoutParams(params);
                 }
             }
        }
    }

    public void onButtonClicked(View view) {

        if (gameOver) return;

        Button stone = (Button) view;
        TextView winner_text = (TextView) findViewById(R.id.winner_text);
        Button rematch_button = (Button) findViewById(R.id.rematch_button);

        if (stone.getText().toString().compareTo("") == 0) {
            {
                if (player == 0) {
                    player = 1;
                    player_turn.setText("Player 2's Turn");
                    stone.setBackgroundResource(R.drawable.black_board);
                    stone.setTextColor(0);
                    stone.setText("G");
                    curr++;

                    if (single) {
                        System.out.println("Computer thinking");
                        Move computerMove = ComputerMove.bestmove("R", makeboard(board), 4, size);

                        System.out.println("Computer says: " + computerMove.i + " " + computerMove.j);
                        player = 0;
                        player_turn.setText("Player 1's Turn");
                        Button cpu = (Button)findViewById(board[computerMove.i][computerMove.j]);
                        cpu.setBackgroundResource(R.drawable.white_board);
                        cpu.setTextColor(0);
                        cpu.setText("R");
                        curr++;
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
                    curr++;
                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.start();
                }
            }
            /*if (winner(row, col)) {  // First, check for a winner.
                int currentPlayer=0;
                if (currentPlayer == WHITE)
                    gameOver("WHITE wins the game!");
                else
                    gameOver("BLACK wins the game!");


                w.dispose();
                return;*/
        }


        if(!standard) {
            if (AnalyzeThis.analyzer("G", makeboard(board))) {
                System.out.println("GREEN WINS!");
                p1_wins++;
                ((TextView) findViewById(R.id.scores_text)).setText(
                        "Player 1: " + p1_wins + "    Player 2: " + p2_wins);
                winner_text.setText(
                        "Player 1 Wins");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;
                timer.stop();

            } else if (AnalyzeThis.analyzer("R", makeboard(board))) {
                System.out.println("RED WINS!");
                p2_wins++;
                ((TextView) findViewById(R.id.scores_text)).setText(
                        "Player 1: " + p1_wins + "    Player 2: " + p2_wins);
                winner_text.setText(
                        "Player 2 Wins");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;
                timer.stop();
            }

            else if(curr == filled){
                winner_text.setText("Stalemate");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;
                timer.stop();
            }
        }
        else{
            if (AnalyzeThis.analyzed("G", makeboard(board), size)) {
                System.out.println("GREEN WINS!");
                p1_wins++;
                ((TextView) findViewById(R.id.scores_text)).setText(
                        "Player 1: " + p1_wins + "    Player 2: " + p2_wins);
                winner_text.setText(
                        "Player 1 Wins");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;
                timer.stop();

            } else if (AnalyzeThis.analyzed("R", makeboard(board), size)) {
                System.out.println("RED WINS!");
                p2_wins++;
                ((TextView) findViewById(R.id.scores_text)).setText(
                        "Player 1: " + p1_wins + "    Player 2: " + p2_wins);
                winner_text.setText(
                        "Player 2 Wins");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;
                timer.stop();
            }

            else if(curr == filled){
                winner_text.setText("Stalemate");
                rematch_button.setVisibility(view.VISIBLE);
                gameOver = true;
                timer.stop();
            }
        }


        }


    public void resetGame(View view) {
        Intent newScreen = new Intent(BoardActivity.this, BoardActivity.class);
        Bundle extras = new Bundle();
        extras.putInt("size", size);
        extras.putBoolean("single", single);
        extras.putBoolean("standard_mode", standard);
        extras.putBoolean("on_line", on_line);
        extras.putInt("score1", p1_wins);
        extras.putInt("score2", p2_wins);
        newScreen.putExtras(extras);
        startActivity(newScreen);
    }

    public void finish(View view) {
        finish();
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
}
    /*not used????????????????
    int win_r1,win_r2,win_c1,win_c2;

    private boolean winner(int row, int col) {
        // This is called just after a piece has been played on the
        // square in the specified row and column.  It determines
        // whether that was a winning move by counting the number
        // of squares in a line in each of the four possible
        // directions from (row,col).  If there are 5 squares (or more)
        // in a row in any direction, then the game is won.

        if (count(board[row][col], row, col, 1, 0) >= 5)
            return true;
        if (count(board[row][col], row, col, 0, 1) >= 5)
            return true;
        if (count(board[row][col], row, col, 1, -1) >= 5)
            return true;
        if (count(board[row][col], row, col, 1, 1) >= 5)
            return true;
        if (count(board[row][col], row, col, 1, 0) >= 5)
            return true;
        if (count(board[row][col], row, col, 0, 1) >= 5)
            return true;
        if (count(board[row][col], row, col, 1, -1) >= 5)
            return true;
        if (count(board[row][col], row, col, 1, 1) >= 5)
            return true;

          // When we get to this point, we know that the game is not
          //   won.  The value of win_r1, which was changed in the count()
          //   method, has to be reset to -1, to avoid drawing a red line
          //   on the board.

        win_r1 = -1;
        return false;

    }  // end winner()  */

    /*not used ??????????????????????????????
    private int count(int player, int row, int col, int dirX, int dirY) {
        // Counts the number of the specified player's pieces starting at
        // square (row,col) and extending along the direction specified by
        // (dirX,dirY).  It is assumed that the player has a piece at
        // (row,col).  This method looks at the squares (row + dirX, col+dirY),
        // (row + 2*dirX, col + 2*dirY), ... until it hits a square that is
        // off the board or is not occupied by one of the players pieces.
        // It counts the squares that are occupied by the player's pieces.
        // Furthermore, it sets (win_r1,win_c1) to mark last position where
        // it saw one of the player's pieces.  Then, it looks in the
        // opposite direction, at squares (row - dirX, col-dirY),
        // (row - 2*dirX, col - 2*dirY), ... and does the same thing.
        // Except, this time it sets (win_r2,win_c2) to mark the last piece.
        // Note:  The values of dirX and dirY must be 0, 1, or -1.  At least
        // one of them must be non-zero.

        int ct = 1;  // Number of pieces in a row belonging to the player.

        int r, c;    // A row and column to be examined

        r = row + dirX;  // Look at square in specified direction.
        c = col + dirY;
        while (r >= 0 && r < 13 && c >= 0 && c < 13 && board[r][c] == player) {
            // Square is on the board and contains one of the players's pieces.
            ct++;
            r += dirX;  // Go on to next square in this direction.
            c += dirY;
        }

        win_r1 = r - dirX;  // The next-to-last square looked at.
       win_c1 = c - dirY;  //    (The LAST one looked at was off the board or
        //    did not contain one of the player's pieces.

        r = row - dirX;  // Look in the opposite direction.
        c = col - dirY;
        while (r >= 0 && r < 13 && c >= 0 && c < 13 && board[r][c] == player) {
            // Square is on the board and contains one of the players's pieces.
            ct++;
            r -= dirX;   // Go on to next square in this direction.
            c -= dirY;
        }

        win_r2 = r + dirX;
        win_c2 = c + dirY;

        // At this point, (win_r1,win_c1) and (win_r2,win_c2) mark the endpoints
        // of the line of pieces belonging to the player.

        return ct;

    }  // end count()  */


