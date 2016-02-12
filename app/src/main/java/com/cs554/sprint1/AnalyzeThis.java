package com.cs554.sprint1;

/**
 * Created by Thomas on 2/4/2016.
 */
public class AnalyzeThis {



    //This is the function that reviews board for win in STANDARD mode
    static boolean analyzed(String s, String[][] board) {
        String ji;
        String jmini, jmin2i, jminimin2;
        String jplusi, jplus2i, jplus2imin;
        String jimin, jimin2;
        String jiplus, jiplus2, jmin2imin;
        String jminimin, jmin2imin2, jmin2iplus;
        String jplusiplus, jplus2iplus2;
        String jminiplus, jmin2iplus2;
        String jplusimin, jplus2imin2;


//if(board)
        for (int j = 3; j < 17; j++)
            for (int i = 3; i < 17; i++) {
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
                String jmin3imin3 = board[j - 3][i - 3];
                String jmin3imin2 = board[j - 3][i - 2];
                String jmin3imin = board[j - 3][i - 1];
                String jmin2imin3 = board[j - 2][i - 3];
                String jminimin3 = board[j - 1][i - 3];
                String jimin3 = board[j][i - 3];
                String jplusimin3 = board[j + 1][i - 3];
                String jplus2imin3 = board[j + 2][i - 3];
                String jplus3imin3 = board[j + 3][i - 3];
                String jplus3imin2 = board[j + 3][i - 2];
                String jplus3imin = board[j + 3][i - 1];
                String jplus3i = board[j + 3][i];
                String jplus3iplus = board[j + 3][i + 1];
                String jplus3iplus2 = board[j + 3][i + 2];
                String jplus3iplus3 = board[j + 3][i + 3];
                String jplus2iplus3 = board[j + 2][i + 3];
                String jplusiplus3 = board[j + 1][i + 3];
                String jiplus3 = board[j][i + 3];
                String jminiplus3 = board[j - 1][i + 3];
                String jmin2iplus3 = board[j - 2][i + 3];
                String jmin3iplus3 = board[j - 3][i + 3];
                String jmin3iplus2 = board[j - 3][i + 2];
                String jmin3iplus = board[j - 3][i + 1];
                String jmin3i = board[j - 3][i];


                if
                    //left diagnol
                        (((ji.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jmin2imin2.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0)
                        && (jmin3imin3.compareTo(s) != 0) && jplus3iplus3.compareTo(s) != 0 )

                        //right diagnol
                        || ((ji.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0)
                        && (jplus3imin3.compareTo(s) != 0) && (jmin3iplus3.compareTo(s) != 0))

                        //horizontal middle
                        || ((ji.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0)
                        && (jimin3.compareTo(s) !=0) && (jiplus3.compareTo(s) != 0))

                        //vertical middle
                        || ((ji.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0)
                        && (jmin3i.compareTo(s) != 0) && jplus3i.compareTo(s) != 0)

                        //horizontal +1
                        || ((jminimin.compareTo(s) == 0) && (jmini.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0)
                        && (jminimin3.compareTo(s) != 0) && jminiplus3.compareTo(s) != 0)

                        //horizontal -1
                        || ((jplusimin.compareTo(s) == 0) && (jplusi.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0) && (jplusimin2.compareTo(s) == 0)
                        && (jplusimin3.compareTo(s) != 0) && (jplusiplus3.compareTo(s) != 0))

                        //horizontal -2
                        || ((jplus2imin.compareTo(s) == 0) && (jplus2i.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0)
                        && (jplus2imin3.compareTo(s)!= 0) && (jplus2iplus3.compareTo(s) != 0))

                        //horizontal +2
                        || ((jmin2imin.compareTo(s) == 0) && (jmin2i.compareTo(s) == 0) && (jmin2iplus.compareTo(s) == 0) && (jmin2iplus2.compareTo(s) == 0) && (jmin2imin2.compareTo(s) == 0)
                        && (jmin2imin3.compareTo(s) != 0) && jmin2iplus3.compareTo(s) != 0)

                        //vertical -2
                        || ((jmin2imin2.compareTo(s) == 0) && (jimin2.compareTo(s) == 0) && (jminimin2.compareTo(s) == 0) && (jplusimin2.compareTo(s) == 0) && (jplus2imin2.compareTo(s) == 0)
                        && (jmin3imin2.compareTo(s) != 0) && (jplus3imin2.compareTo(s) != 0))

                        //vertical +2
                        || ((jmin2iplus2.compareTo(s) == 0) && (jminiplus2.compareTo(s) == 0) && (jiplus2.compareTo(s) == 0) && (jplusiplus2.compareTo(s) == 0) && (jplus2iplus2.compareTo(s) == 0)
                        && (jmin3iplus2.compareTo(s) != 0) && (jplus3iplus2.compareTo(s) != 0))

                        //vertical -1
                        || ((jmin2imin.compareTo(s) == 0) && (jminimin.compareTo(s) == 0) && (jimin.compareTo(s) == 0) && (jplusimin.compareTo(s) == 0) && (jplus2imin.compareTo(s) == 0)
                        && (jmin3imin.compareTo(s) != 0) && (jplus3imin.compareTo(s) != 0))

                        //vertical +1
                        || ((jmin2iplus.compareTo(s) == 0) && (jminiplus.compareTo(s) == 0) && (jiplus.compareTo(s) == 0) && (jplusiplus.compareTo(s) == 0) && (jplus2iplus.compareTo(s) == 0)
                        && (jmin3iplus.compareTo(s) != 0) && (jplus3iplus.compareTo(s) != 0))

                        //horizontal +3
                        || ((jmin3imin3.compareTo(s) != 0) && (jmin3imin2.compareTo(s) ==0) && (jmin3imin.compareTo(s) == 0) && (jmin3i.compareTo(s) == 0) && jmin3iplus.compareTo(s) == 0)
                        && (jmin3iplus2.compareTo(s) ==0) && (jmin3iplus3.compareTo(s) != 0)

                        //vertical -3
                        || ((jmin3imin3.compareTo(s) !=0) && (jmin2imin3.compareTo(s) == 0) && (jminimin3.compareTo(s) == 0) && (jimin3.compareTo(s) ==0) && (jplusimin3.compareTo(s) == 0)
                        &&( jplus2imin3.compareTo(s) == 0) && (jplus3imin3.compareTo(s) != 0))

                        ) {
                    return true;
                }
            }
        return false;
    }


    //This checks for a win in FREESTYLE mode
    static boolean analyzer(String s, String[][] board) {
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
}
