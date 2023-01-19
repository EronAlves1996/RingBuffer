package com.eronalves;

public class Cursor {

    private int readPos = 0;
    private int writePos = -1;
    private int maxPos;

    public static Cursor initialize(int allocationSize) {
        return new Cursor(allocationSize);
    }

    private Cursor(int maxVal){
        this.maxPos = maxVal;
    }

    public int nextWrite() {
        writePos = ++writePos % maxPos;
        return writePos;
    }

    public int nextRead() {
        int temp = readPos;
        readPos = ++readPos % maxPos;
        return temp;
    }

}
