package com.cs554.sprint1;

import junit.framework.TestCase;

/**
 * Created by Thomas on 2/10/2016.
 */
public class AnalyzerTest extends TestCase {
    public void testAnalyzer(){

        //test Row top right to bottom left
        String[][] test_board = new String[20][20];
        int len = 5;
        boolean test;

        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size-len+1; j++){
                   // System.out.print(size+" "+i+" "+j+" row1 \n");
                    clearBoard(test_board);
                    test_board[i][j] = test_board[i][j+1] = test_board[i][j+2]
                        = test_board[i][j+3] = test_board[i][j+4] = "x";
                    test = AnalyzeThis.analyzer("x", test_board);
                    assertEquals(true, test);
                }
            }
        }

        //test bottom left to top right
        clearBoard(test_board);
        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = size; i < 1; i--){
                for (int j = size; j < len -1; j--){
                    //System.out.print(size+" "+i+" "+j+"row2\n");
                    clearBoard(test_board);
                        test_board[i][j] = test_board[i][j-1] = test_board[i][j-2]
                                = test_board[i][j-3] = test_board[i][j-4] = "x";
                        test = AnalyzeThis.analyzer("x", test_board);
                        assertEquals(true, test);
                }
            }
        }

//test for non wins rows
        clearBoard(test_board);
        for (int size = 10; size <= 20; size+= 5)
            for (int i = 0; i < size; i+=5)
                for (int j = 0; j < size-len+1; j+= 5)
                    for (int k = 0; k < 5; k++)
                        for (int l = 0; l < 5; l++)
                            for (int m = 0; m < 5; m++)
                                for (int n = 0; n < 5; n++)
                                    for (int o = 0; o < 5; o++){
                                        test_board[i][j+k] = "x";
                                        test_board[i][j+l] = "x";
                                        test_board[i][j+m] = "x";
                                        test_board[i][j+n] = "x";
                                        test_board[i][j+o] = "y";
                                        test = AnalyzeThis.analyzer("x", test_board);
                                        assertEquals(false, test);
                                        test_board[i][j+k] = " ";
                                        test_board[i][j+l] = " ";
                                        test_board[i][j+m] = " ";
                                        test_board[i][j+n] = " ";
                                        test_board[i][j+o] = " ";
                                    }

System.out.print("Columns\n");
        for (int size = 10; size <= 20; size += 5) {
            //columns top right to bottom left
            for (int i = 0; i < size - len+1; i++){
                for (int j = 0; j < size; j++){
                    //System.out.print(size+" "+i+" "+j+"col1\n");
                    clearBoard(test_board);
                        test_board[i][j] = test_board[i+1][j] = test_board[i+2][j]
                                = test_board[i+3][j] = test_board[i+4][j] = "x";
                        test = AnalyzeThis.analyzer("x", test_board);
                        assertEquals(true, test);
                }
            }
        }

        //test column bottom left to top right
        clearBoard(test_board);
        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = size; i < len-1; i--){
                for (int j = size; j < 1; j--){
                    //System.out.print(size+" "+i+" "+j+"col2\n");
                    clearBoard(test_board);
                        test_board[i][j] = test_board[i-1][j] = test_board[i-2][j]
                                = test_board[i-3][j] = test_board[i-4][j] = "x";
                    test = AnalyzeThis.analyzer("x", test_board);
                    assertEquals(true, test);
                }
            }
        }

        //test for non wins columns
        clearBoard(test_board);
        for (int size = 10; size <= 20; size+= 5)
            for (int i = 0; i < size-len+1; i+=5)
                for (int j = 0; j < size; j+= 5)
                    for (int k = 0; k < 5; k++)
                        for (int l = 0; l < 5; l++)
                            for (int m = 0; m < 5; m++)
                                for (int n = 0; n < 5; n++)
                                    for (int o = 0; o < 5; o++){
                                        test_board[i+k][j] = "x";
                                        test_board[i+l][j] = "x";
                                        test_board[i+m][j] = "x";
                                        test_board[i+n][j] = "x";
                                        test_board[i+o][j] = "y";
                                        test = AnalyzeThis.analyzer("x", test_board);
                                        assertEquals(false, test);
                                        test_board[i+k][j] = " ";
                                        test_board[i+l][j] = " ";
                                        test_board[i+m][j] = " ";
                                        test_board[i+n][j] = " ";
                                        test_board[i+o][j] = " ";
                                    }


        for (int size = 10; size <= 20; size += 5) {
            //diagonal right to left (check lines like [0,4][1,3][2,2][3,1][4,0])
            for (int i = 0; i < size - len+1; i++){
                for (int j = len-1; j < size; j++){
                    //System.out.print(size+" "+i+" "+j+"di1\n");
                    clearBoard(test_board);
                    test_board[i][j] = test_board[i + 1][j - 1] = test_board[i + 2][j - 2] =
                            test_board[i + 3][j - 3] = test_board[i + 4][j - 4] = "x";
                    test = AnalyzeThis.analyzer("x", test_board);
                    assertEquals(true, test);
                }
            }
        }

        //test for non wins diag right to left
        clearBoard(test_board);
        for (int size = 10; size <= 20; size+= 5)
            for (int i = 0; i < size-len+1; i+=5)
                for (int j = len-1; j < size; j+= 5)
                    for (int k = 0; k < 5; k++)
                        for (int l = 0; l < 5; l++)
                            for (int m = 0; m < 5; m++)
                                for (int n = 0; n < 5; n++)
                                    for (int o = 0; o < 5; o++){
                                        test_board[i+k][j-k] = "x";
                                        test_board[i+l][j-l] = "x";
                                        test_board[i+m][j-m] = "x";
                                        test_board[i+n][j-n] = "x";
                                        test_board[i+o][j-o] = "y";
                                        test = AnalyzeThis.analyzer("x", test_board);
                                        assertEquals(false, test);
                                        test_board[i+k][j-k] = " ";
                                        test_board[i+l][j-l] = " ";
                                        test_board[i+m][j-m] = " ";
                                        test_board[i+n][j-n] = " ";
                                        test_board[i+o][j-o] = " ";
                                    }



        //test left to right (check lines like [0,0][1,1][2,2][3,3][4,4])
        clearBoard(test_board);
        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = 0; i < size - len+1; i++){
                for (int j = 0; j < size - len+1; j++){
                    //System.out.print(size+" "+i+" "+j+"di2\n");
                    clearBoard(test_board);
                    test_board[i][j] = test_board[i + 1][j + 1] = test_board[i + 2][j + 2] =
                            test_board[i + 3][j + 3] = test_board[i + 4][j + 4] = "x";
                    test = AnalyzeThis.analyzer("x", test_board);
                    assertEquals(true, test);
                }
            }
        }

        //test for non wins diag left to right
        clearBoard(test_board);
        for (int size = 10; size <= 20; size+= 5)
            for (int i = 0; i < size-len+1; i+=5)
                for (int j = 0; j < size-len+1; j+= 5)
                    for (int k = 0; k < 5; k++)
                        for (int l = 0; l < 5; l++)
                            for (int m = 0; m < 5; m++)
                                for (int n = 0; n < 5; n++)
                                    for (int o = 0; o < 5; o++){
                                        test_board[i+k][j+k] = "x";
                                        test_board[i+l][j+l] = "x";
                                        test_board[i+m][j+m] = "x";
                                        test_board[i+n][j+n] = "x";
                                        test_board[i+o][j+o] = "y";
                                        test = AnalyzeThis.analyzer("x", test_board);
                                        assertEquals(false, test);
                                        test_board[i+k][j+k] = " ";
                                        test_board[i+l][j+l] = " ";
                                        test_board[i+m][j+m] = " ";
                                        test_board[i+n][j+n] = " ";
                                        test_board[i+o][j+o] = " ";
                                    }

  }



    public void clearBoard(String[][] board){
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                board[i][j] = " ";
            }
        }
    }
}
