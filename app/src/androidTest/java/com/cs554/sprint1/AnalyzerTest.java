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
                    System.out.print(size+" "+i+" "+j+" row1 \n");
                    clearBoard(test_board);
                    for (int k = 0; k < 5; k++){
                        for (int l = 0; l < 5; l++)
                            for (int m = 0; m < 5; m++)
                                for (int n = 0; n < 5; n++)
                                    for (int o = 0; o < 5; o++){
                                        test_board[i][j+k] = "x";
                                        test_board[i][j+l] = "x";
                                        test_board[i][j+m] = "x";
                                        test_board[i][j+n] = "x";
                                        test_board[i][j+o] = "x";
                                        if ((k+l+m+n+o == 10) && (k != l) && (k != m) && (k!=n) && (k!=o)
                                                && (l!= m) && (l!=n) &&(l!=o)
                                                && (m!= n) && (m!=o) && (n!= o)){
                                            test = AnalyzeThis.analyzer("x", test_board);
                                            assertEquals(true, test);
                                        }
                                        else{
                                            test = AnalyzeThis.analyzer("x", test_board);
                                            assertEquals(false, test);
                                        }
                                        test_board[i][j+k] = " ";
                                        test_board[i][j+l] = " ";
                                        test_board[i][j+m] = " ";
                                        test_board[i][j+n] = " ";
                                        test_board[i][j+o] = " ";
                                    }
/*                        test_board[i][j+k] = "x";
                        if (k < 4) {
                          //  System.out.print("i: "+ (i+k) + " j: " +j+"\n");
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(false, test);
                        }
                        else {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(true, test);
                        }*/
                    }
                }
            }
        }

        //test bottom left to top right
        clearBoard(test_board);
        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = size; i < 1; i--){
                for (int j = size; j < len -1; j--){
                    System.out.print(size+" "+i+" "+j+"row2\n");
                    clearBoard(test_board);
                    for (int k = 0; k < 5; k++){
                        test_board[i][j-k] = "x";
                        if (k < 4) {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(false, test);
                        }
                        else {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(true, test);
                        }
                    }
                }
            }
        }

System.out.print("Columns\n");
        for (int size = 10; size <= 20; size += 5) {
            //columns top right to bottom left
            for (int i = 0; i < size - len+1; i++){
                for (int j = 0; j < size; j++){
                    System.out.print(size+" "+i+" "+j+"col1\n");
                    clearBoard(test_board);
                    for (int k = 0; k < 5; k++){
                        test_board[i+k][j] = "x";
                        if (k < 4) {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(false, test);
                        }
                        else {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(true, test);
                        }
                    }
                }
            }
        }

        //test column bottom left to top right
        clearBoard(test_board);
        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = size; i < len-1; i--){
                for (int j = size; j < 1; j--){
                    System.out.print(size+" "+i+" "+j+"col2\n");
                    clearBoard(test_board);
                    for (int k = 0; k < 5; k++){
                        test_board[i-k][j] = "x";
                        if (k < 4) {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(false, test);
                        }
                        else {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(true, test);
                        }
                    }
                }
            }
        }


        for (int size = 10; size <= 20; size += 5) {
            //diagonal right to left (check lines like [0,4][1,3][2,2][3,1][4,0])
            for (int i = 0; i < size - len+1; i++){
                for (int j = len-1; j < size; j++){
                    System.out.print(size+" "+i+" "+j+"di1\n");
                    clearBoard(test_board);
                    for (int k = 0; k < 5; k++){
                        test_board[i +k ][j - k] = "x";
                        if (k < 4) {
                            System.out.print("i: "+ (i+k) + " j: " +(j-k)+"\n");
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(false, test);
                        }
                        else {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(true, test);
                        }
                    }
                }
            }
        }

        //test left to right (check lines like [0,0][1,1][2,2][3,3][4,4])
        clearBoard(test_board);
        for (int size = 10; size <= 20; size += 5) {
            //rows
            for (int i = 0; i < size - len+1; i++){
                for (int j = 0; j < size - len+1; j++){
                    System.out.print(size+" "+i+" "+j+"di2\n");
                    clearBoard(test_board);
                    for (int k = 0; k < 5; k++){
                        test_board[i + k][j + k] = "x";
                        if (k < 4) {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(false, test);
                        }
                        else {
                            test = AnalyzeThis.analyzer("x", test_board);
                            assertEquals(true, test);
                        }
                    }
                }
            }
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
