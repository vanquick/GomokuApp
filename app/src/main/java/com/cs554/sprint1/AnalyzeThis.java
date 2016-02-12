package com.cs554.sprint1;

/**
 * Created by Thomas on 2/4/2016.
 */
public class AnalyzeThis {



    //This is the function that reviews board for win in STANDARD mode
    static boolean analyzed(String s, String[][] board, int size) {
        int len = 5;
        //check rows
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - len + 1; j++) {
                if (j == 0){
                    if (board[i][j].compareTo(s) == 0
                            && board[i][j+1].compareTo(s) == 0
                            && board[i][j+2].compareTo(s) == 0
                            && board[i][j+3].compareTo(s) == 0
                            && board[i][j+4].compareTo(s) == 0
                            && board[i][j+5].compareTo(s) != 0
                            ){
                        return true;
                    }
                }
                if (j == size - len){
                    if (board[i][j].compareTo(s) == 0
                            && board[i][j+1].compareTo(s) == 0
                            && board[i][j+2].compareTo(s) == 0
                            && board[i][j+3].compareTo(s) == 0
                            && board[i][j+4].compareTo(s) == 0
                            && board[i][j-1].compareTo(s) != 0
                            ) {
                        return true;
                    }
                }
                if (board[i][j].compareTo(s) == 0
                        && board[i][j+1].compareTo(s) == 0
                        && board[i][j+2].compareTo(s) == 0
                        && board[i][j+3].compareTo(s) == 0
                        && board[i][j+4].compareTo(s) == 0
                        && (
                        (board[i][j-1].compareTo(" ") == 0
                            && (board[i][j+5].compareTo(s) != 0 && board[i][j+5].compareTo(" ") != 0))
                        || ( (board[i][j-1].compareTo(s) != 0 && board[i][j-1].compareTo(" ") != 0)
                            && (board[i][j+5].compareTo(" ") == 0))
                        || ( (board[i][j-1].compareTo(" ") == 0 && board[i][j+5].compareTo(" ") == 0)) )
                        ) {
                    return true;
                }
            }
        }

        //check columns
        for (int i = 0; i < size - len + 1; i++){
            for (int j = 0; j < size; j++){
                if (i == 0){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j].compareTo(s) == 0
                            && board[i+2][j].compareTo(s) == 0
                            && board[i+3][j].compareTo(s) == 0
                            && board[i+4][j].compareTo(s) == 0
                            && board[i+5][j].compareTo(s) != 0
                            ){
                        return true;
                    }
                }
                if (i == size - len){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j].compareTo(s) == 0
                            && board[i+2][j].compareTo(s) == 0
                            && board[i+3][j].compareTo(s) == 0
                            && board[i+4][j].compareTo(s) == 0
                            && board[i-1][j].compareTo(s) != 0
                            ){
                        return true;
                    }
                }
                if (board[i][j].compareTo(s) == 0
                        && board[i+1][j].compareTo(s) == 0
                        && board[i+2][j].compareTo(s) == 0
                        && board[i+3][j].compareTo(s) == 0
                        && board[i+4][j].compareTo(s) == 0
                        && (
                        (board[i-1][j].compareTo(" ") == 0
                                && (board[i+5][j].compareTo(s) != 0 && board[i+5][j].compareTo(" ") != 0))
                                || ( (board[i-1][j].compareTo(s) != 0 && board[i-1][j].compareTo(" ") != 0)
                                && (board[i+5][j].compareTo(" ") == 0))
                                || ( (board[i-1][j].compareTo(" ") == 0 && board[i+5][j].compareTo(" ") == 0)) )
                        ){
                    return true;
                }
            }
        }

        //check diagonal left to right
        for (int i = 0; i < size - len + 1; i++){
            for (int j = 0; j < size - len + 1; j++){
                if ( (i == 0 && j == size - len) || (i == size - len && j == 0) ){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j+1].compareTo(s) == 0
                            && board[i+2][j+2].compareTo(s) == 0
                            && board[i+3][j+3].compareTo(s) == 0
                            && board[i+4][j+4].compareTo(s) == 0
                            ){
                        return true;
                    }
                }
                if ( (i == 0 && j < size - len) || (i < size - len && j == 0) ){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j+1].compareTo(s) == 0
                            && board[i+2][j+2].compareTo(s) == 0
                            && board[i+3][j+3].compareTo(s) == 0
                            && board[i+4][j+4].compareTo(s) == 0
                            && board[i+5][j+5].compareTo(s) != 0
                            ){
                        return true;
                    }
                }
                if ( (i == size - len && j > 0) || (i > 0 && j == size - len) ){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j+1].compareTo(s) == 0
                            && board[i+2][j+2].compareTo(s) == 0
                            && board[i+3][j+3].compareTo(s) == 0
                            && board[i+4][j+4].compareTo(s) == 0
                            && board[i-1][j-1].compareTo(s) != 0
                            ){
                        return true;
                    }
                }
                if (board[i][j].compareTo(s) == 0
                        && board[i+1][j+1].compareTo(s) == 0
                        && board[i+2][j+2].compareTo(s) == 0
                        && board[i+3][j+3].compareTo(s) == 0
                        && board[i+4][j+4].compareTo(s) == 0
                        && (
                        (board[i-1][j-1].compareTo(" ") == 0
                                && (board[i+5][j+5].compareTo(s) != 0 && board[i+5][j+5].compareTo(" ") != 0))
                                || ( (board[i-1][j-1].compareTo(s) != 0 && board[i-1][j-1].compareTo(" ") != 0)
                                && (board[i+5][j+5].compareTo(" ") == 0))
                                || ( (board[i-1][j-1].compareTo(" ") == 0 && board[i+5][j+5].compareTo(" ") == 0)) )
                        ){
                    return true;
                }
            }
        }
        //check diagonal right to left
        for (int i = 0; i < size - len + 1; i++){
            for (int j = len - 1; j < size; j++){
                if ( (i == 0 && j == len - 1) || (i == size - 1 && j == size - 1) ){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j-1].compareTo(s) == 0
                            && board[i+2][j-2].compareTo(s) == 0
                            && board[i+3][j-3].compareTo(s) == 0
                            && board[i+4][j-4].compareTo(s) == 0
                            ){
                        return true;
                    }
                }
                if ( (i == 0 && j > len - 1) || (i < size - len && j == size - 1) ){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j-1].compareTo(s) == 0
                            && board[i+2][j-2].compareTo(s) == 0
                            && board[i+3][j-3].compareTo(s) == 0
                            && board[i+4][j-4].compareTo(s) == 0
                            && board[i+5][j-5].compareTo(s) != 0
                            ){
                        return true;
                    }
                }
                if ( (i > 0 && j == len - 1) || (i == size - len && j < size - 1) ){
                    if (board[i][j].compareTo(s) == 0
                            && board[i+1][j-1].compareTo(s) == 0
                            && board[i+2][j-2].compareTo(s) == 0
                            && board[i+3][j-3].compareTo(s) == 0
                            && board[i+4][j-4].compareTo(s) == 0
                            && board[i-1][j+1].compareTo(s) != 0
                            ){
                        return true;
                    }
                }
                if (board[i][j].compareTo(s) == 0
                        && board[i+1][j-1].compareTo(s) == 0
                        && board[i+2][j-2].compareTo(s) == 0
                        && board[i+3][j-3].compareTo(s) == 0
                        && board[i+4][j-4].compareTo(s) == 0
                        && (
                        (board[i-1][j+1].compareTo(" ") == 0
                                && (board[i+5][j-5].compareTo(s) != 0 && board[i+5][j-5].compareTo(" ") != 0))
                                || ( (board[i-1][j+1].compareTo(s) != 0 && board[i-1][j+1].compareTo(" ") != 0)
                                && (board[i+5][j-5].compareTo(" ") == 0))
                                || ( (board[i-1][j+1].compareTo(" ") == 0 && board[i+5][j-5].compareTo(" ") == 0)) )
                        ){
                    return true;
                }
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
