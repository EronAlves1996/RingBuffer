package com.eronalves;

public class Tracker {
    private int capacity;
    private int size;

    public Tracker(int initialCapacity){
        this.capacity = initialCapacity;
        size = 0;
    }

    public void increase() {
        capacity--;
        size++;
    }

    public void decrease() {
        capacity++;
        size--;
    }

    public boolean sizeIsZero() {
        return size <= 0;
    }

    public boolean capacityIsZero() {
        return capacity <= 0;
    }
}
