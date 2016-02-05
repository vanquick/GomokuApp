package com.cs554.sprint1;

import java.util.Arrays;

/**
 * Created by Thomas on 2/4/2016.
 */
public class ComputerMove {

    //This checks for the best move that the computer can make
    //helper analyze functions are below (analyzer 2 - 5)
    static Move bestmove(String s, String board[][], int depth, int board_size) {
        Move move, worstMove;
        int size = board_size;
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
                        bestMove = new Move(i, j, 1);
                        thisBoard[i][j] = " ";
                        System.out.println("winner" + i + " " + j);
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

    static int analyzer5(String s, String[][] board) {
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

    static int analyzer4(String s, String[][] board) {
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

    static int analyzer3(String s, String[][] board) {
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

    static int analyzer2(String s, String[][] board) {
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
}
