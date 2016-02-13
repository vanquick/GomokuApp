package com.cs554.sprint1;

import junit.framework.TestCase;

/**
 * Created by Thomas on 2/12/2016.
 */
public class AnalyzedTest extends TestCase {
    public void testAnalyzed(){
        //test Row top right to bottom left
        String[][] test_board = new String[20][20];
        int len = 6;
        boolean test;

        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size-len+1; j++){
                    if(j == 0) {
                      //  System.out.print("1 " + size + " " + i + " " + j + " row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i][j + 1] = test_board[i][j + 2]
                                = test_board[i][j + 3] = test_board[i][j + 4] = test_board[i][j + 5] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i][j + 5] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i][j + 5] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    if(j == size - len) {
                      //  System.out.print("2 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i][j + 1] = test_board[i][j + 2]
                                = test_board[i][j + 3] = test_board[i][j + 4] = test_board[i][j -1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i][j -1] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i][j -1] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    if(j > 0 && j < size - len) {
                      //  System.out.print("3 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        //_..._
                        test_board[i][j] = test_board[i][j + 1] = test_board[i][j + 2]
                                = test_board[i][j + 3] = test_board[i][j + 4] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //x..._
                        test_board[i][j-1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...x
                        test_board[i][j-1] = " ";
                        test_board[i][j +5] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //x...x
                        test_board[i][j - 1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //y...y
                        test_board[i][j -1] = test_board[i][j+5] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...y
                        test_board[i][j -1] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //y..._
                        test_board[i][j-1] = "y";
                        test_board[i][j+5] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                }
            }
        }


//test for non wins rows

        for (int size = 10; size <= 20; size+= 5) {
            clearBoard(test_board, size);
            for (int i = 0; i < size; i += 5)
                for (int j = 0; j < size - len + 1; j += 5)
                    for (int k = 0; k < 6; k++)
                        for (int l = 0; l < 6; l++)
                            for (int m = 0; m < 6; m++)
                                for (int n = 0; n < 6; n++)
                                    for (int o = 0; o < 6; o++)
                                        for (int p = 0; p < 6; p++){
                                            test_board[i][j + k] = "x";
                                            test_board[i][j + l] = "x";
                                            test_board[i][j + m] = "x";
                                            test_board[i][j + n] = "x";
                                            test_board[i][j + o] = "y";
                                            test_board[i][j + p] = "y";
                                            test = AnalyzeThis.analyzed("x", test_board, size);
                                            assertEquals(false, test);
                                            test_board[i][j + k] = " ";
                                            test_board[i][j + l] = " ";
                                            test_board[i][j + m] = " ";
                                            test_board[i][j + n] = " ";
                                            test_board[i][j + o] = " ";
                                            test_board[i][j + p] = " ";
                                        }
        }


        //columns
        for (int size = 10; size <= 20; size += 5) {
            for (int i = 0; i < size - len + 1; i++){
                for (int j = 0; j < size; j++){
                    if(i == 0) {
                        //  System.out.print("1 " + size + " " + i + " " + j + " row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j] = test_board[i + 2][j]
                                = test_board[i + 3][j] = test_board[i + 4][j] = test_board[i + 5][j] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i + 5][j] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i + 5][j] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    if(i == size - len) {
                        //  System.out.print("2 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j] = test_board[i + 2][j]
                                = test_board[i + 3][j] = test_board[i + 4][j] = test_board[i -1][j] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i -1][j] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i -1][j] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    if(i > 0 && i < size - len) {
                        //  System.out.print("3 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        //_..._
                        test_board[i][j] = test_board[i + 1][j] = test_board[i + 2][j]
                                = test_board[i + 3][j] = test_board[i + 4][j] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //x..._
                        test_board[i-1][j] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...x
                        test_board[i-1][j] = " ";
                        test_board[i +5][j] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //x...x
                        test_board[i - 1][j] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //y...y
                        test_board[i -1][j] = test_board[i+5][j] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...y
                        test_board[i -1][j] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //y..._
                        test_board[i-1][j] = "y";
                        test_board[i+5][j] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                }
            }
        }


//test for non wins rows

        for (int size = 10; size <= 20; size+= 5) {
            clearBoard(test_board, size);
            for (int i = 0; i < size - len + 1; i += 5)
                for (int j = 0; j < size; j += 5)
                    for (int k = 0; k < 6; k++)
                        for (int l = 0; l < 6; l++)
                            for (int m = 0; m < 6; m++)
                                for (int n = 0; n < 6; n++)
                                    for (int o = 0; o < 6; o++)
                                        for (int p = 0; p < 6; p++){
                                            test_board[i + k][j] = "x";
                                            test_board[i + l][j] = "x";
                                            test_board[i + m][j] = "x";
                                            test_board[i + n][j] = "x";
                                            test_board[i + o][j] = "y";
                                            test_board[i + p][j] = "y";
                                            test = AnalyzeThis.analyzed("x", test_board, size);
                                            assertEquals(false, test);
                                            test_board[i + k][j] = " ";
                                            test_board[i + l][j] = " ";
                                            test_board[i + m][j] = " ";
                                            test_board[i + n][j] = " ";
                                            test_board[i + o][j] = " ";
                                            test_board[i + p][j] = " ";
                                        }
        }


        //digagonal left to right
        for (int size = 10; size <= 20; size += 5) {
            for (int i = 0; i < size - len + 1; i++){
                for (int j = 0; j < size - len + 1; j++){
                    //case of no room for more than 5
                    if( (i == 0 && j == size - len) || (i == size - len && j == 0) ) {
                        //  System.out.print("1 " + size + " " + i + " " + j + " row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j + 1] = test_board[i + 2][j + 2]
                                = test_board[i + 3][j + 3] = test_board[i + 4][j + 4] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    //case of only room for extra on the bottom right of the diagonal
                    else if( (i == 0 && j < size - len) || (i < size - len && j == 0) ) {
                        //  System.out.print("2 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j + 1] = test_board[i + 2][j + 2]
                                = test_board[i + 3][j + 3] = test_board[i + 4][j + 4] = test_board[i + 5][j + 5] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i + 5][j + 5] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i + 5][j + 5] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    //cas where only room on the left top of the diagonal
                    else if( (i == size - len && j > 0) || (i > 0 && j == size - len) ) {
                        //  System.out.print("3 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j + 1] = test_board[i + 2][j + 2]
                                = test_board[i + 3][j + 3] = test_board[i + 4][j + 4] = test_board[i - 1][j - 1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i - 1][j - 1] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i - 1][j - 1] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    //cas where checking past each side of diagonal
                    else {
                        //System.out.print("3 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        //_..._
                        test_board[i][j] = test_board[i + 1][j + 1] = test_board[i + 2][j + 2]
                                = test_board[i + 3][j + 3] = test_board[i + 4][j + 4] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //x..._
                        test_board[i - 1][j - 1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...x
                        test_board[i - 1][j - 1] = " ";
                        test_board[i + 5][j + 5] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //x...x
                        test_board[i - 1][j - 1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //y...y
                        test_board[i - 1][j - 1] = test_board[i + 5][j + 5] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...y
                        test_board[i - 1][j - 1] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //y..._
                        test_board[i - 1][j - 1] = "y";
                        test_board[i + 5][j + 5] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                }
            }
        }


//test for non wins diag left to right

        for (int size = 10; size <= 20; size+= 5) {
            clearBoard(test_board, size);
            for (int i = 0; i < size - len + 1; i += 5)
                for (int j = 0; j < size - len + 1; j += 5)
                    for (int k = 0; k < 6; k++)
                        for (int l = 0; l < 6; l++)
                            for (int m = 0; m < 6; m++)
                                for (int n = 0; n < 6; n++)
                                    for (int o = 0; o < 6; o++)
                                        for (int p = 0; p < 6; p++){
                                            test_board[i + k][j + k] = "x";
                                            test_board[i + l][j + l] = "x";
                                            test_board[i + m][j + m] = "x";
                                            test_board[i + n][j + n] = "x";
                                            test_board[i + o][j + o] = "y";
                                            test_board[i + p][j + p] = "y";
                                            test = AnalyzeThis.analyzed("x", test_board, size);
                                            assertEquals(false, test);
                                            test_board[i + k][j + k] = " ";
                                            test_board[i + l][j + l] = " ";
                                            test_board[i + m][j + m] = " ";
                                            test_board[i + n][j + n] = " ";
                                            test_board[i + o][j + o] = " ";
                                            test_board[i + p][j + p] = " ";
                                        }
        }

        //digagonal right to left
        for (int size = 10; size <= 20; size += 5) {
            for (int i = 0; i < size - len + 1; i++){
                for (int j = len - 1; j < size; j++){
                    //case of no room for more than 5
                    if( (i == 0 && j == len - 1) || (i == size - 1 && j == size - 1) ) {
                        //System.out.print("1 " + size + " " + i + " " + j + " row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j - 1] = test_board[i + 2][j - 2]
                                = test_board[i + 3][j - 3] = test_board[i + 4][j - 4] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    //case of only room for extra on the bottom left of the diagonal
                    else if( (i == 0 && j > len - 1) || (i < size - len +1 && j == size - 1) ) {
                        //System.out.print("2 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j - 1] = test_board[i + 2][j - 2]
                                = test_board[i + 3][j - 3] = test_board[i + 4][j - 4] = test_board[i + 5][j - 5] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i + 5][j - 5] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i + 5][j - 5] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    //cas where only room on the right top of the diagonal
                    else if( (i > 0 && j == len - 1) || (i == size - len && j < size - 1) ) {
                        //System.out.print("3 "+size+" "+i+" "+j+" row1 \n");
                        clearBoard(test_board, size);
                        test_board[i][j] = test_board[i + 1][j - 1] = test_board[i + 2][j - 2]
                                = test_board[i + 3][j - 3] = test_board[i + 4][j - 4] = test_board[i - 1][j + 1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        test_board[i - 1][j + 1] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        test_board[i - 1][j + 1] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                    //cas where checking past each side of diagonal
                    else {
                        //System.out.print("3 " + size + " " + i + " " + j + " row1 \n");
                        clearBoard(test_board, size);
                        //_..._
                        test_board[i][j] = test_board[i + 1][j - 1] = test_board[i + 2][j - 2]
                                = test_board[i + 3][j - 3] = test_board[i + 4][j - 4] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //x..._
                        test_board[i - 1][j + 1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...x
                        test_board[i - 1][j + 1] = " ";
                        test_board[i + 5][j - 5] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //x...x
                        test_board[i - 1][j + 1] = "x";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //y...y
                        test_board[i - 1][j + 1] = test_board[i + 5][j - 5] = "y";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(false, test);
                        //_...y
                        test_board[i - 1][j + 1] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                        //y..._
                        test_board[i - 1][j + 1] = "y";
                        test_board[i + 5][j - 5] = " ";
                        test = AnalyzeThis.analyzed("x", test_board, size);
                        assertEquals(true, test);
                    }
                }
            }
        }


//test for non wins diag right to left

        for (int size = 10; size <= 20; size+= 5) {
            clearBoard(test_board, size);
            for (int i = 0; i < size - len + 1; i += 5)
                for (int j = len - 1; j < size; j += 5)
                    for (int k = 0; k < 6; k++)
                        for (int l = 0; l < 6; l++)
                            for (int m = 0; m < 6; m++)
                                for (int n = 0; n < 6; n++)
                                    for (int o = 0; o < 6; o++)
                                        for (int p = 0; p < 6; p++){
                                            test_board[i + k][j - k] = "x";
                                            test_board[i + l][j - l] = "x";
                                            test_board[i + m][j - m] = "x";
                                            test_board[i + n][j - n] = "x";
                                            test_board[i + o][j - o] = "y";
                                            test_board[i + p][j - p] = "y";
                                            test = AnalyzeThis.analyzed("x", test_board, size);
                                            assertEquals(false, test);
                                            test_board[i + k][j - k] = " ";
                                            test_board[i + l][j - l] = " ";
                                            test_board[i + m][j - m] = " ";
                                            test_board[i + n][j - n] = " ";
                                            test_board[i + o][j - o] = " ";
                                            test_board[i + p][j - p] = " ";
                                        }
        }

    }

    public void clearBoard(String[][] board, int size){
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                board[i][j] = " ";
            }
        }
    }
}
