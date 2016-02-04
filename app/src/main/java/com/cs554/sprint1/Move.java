package com.cs554.sprint1;

/**
 * Created by Sunil_Shenoy on 1/29/2016.
 */
public class Move {

    public int i, j, value;

    public Move(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public int getVal() {
        return this.value;
    }

    public void setVal(int value) {
        this.value = value;
    }
}
