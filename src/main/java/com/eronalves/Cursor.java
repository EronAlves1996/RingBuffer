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
        return writePos = (writePos + 1) % maxPos;
    }

    public int nextRead() {
        int temp = readPos;
        readPos = (readPos + 1) % maxPos;
        return temp;
    }

}
