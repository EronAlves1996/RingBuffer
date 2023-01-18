package com.eronalves;

public class Cursor {

    private int readPos = -1;
    private int writePos = 0;
    private int maxPos;

    public static Cursor initialize(int allocationSize) {
        return new Cursor(allocationSize);
    }

    private Cursor(int maxVal){
        this.maxPos = maxVal;
    }

    public int nextWrite() {
        return (writePos++ % maxPos);
    }

    public int nextRead() {
        return (++readPos % maxPos);
    }
}
