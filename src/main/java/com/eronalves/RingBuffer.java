package com.eronalves;

import java.util.ArrayList;
import java.util.List;

public class RingBuffer<T> {

    private final List<T> buffer;
    private final Cursor cursor;

    private Tracker tracker;


    public RingBuffer(int allocationSize){
        buffer = new ArrayList<>(allocationSize);
        cursor = Cursor.initialize(allocationSize);
        tracker = new Tracker(allocationSize);
    }

    public void insertOrRewrite(T element){
        buffer[cursor.nextWrite()] = element;
        tracker.increase();
    }

    public void insertWithoutRewrite(T element){
        if(isFull()) throw new RuntimeException("Buffer is Full");
        insertOrRewrite(element);
    }

    public T read(){
        if(isEmpty()) return null;
        tracker.decrease();
        return buffer[cursor.nextRead()];
    }

    public boolean isEmpty(){
        return cursor.writeIsBehindRead();
    }

    public boolean isFull(){
        return cursor.writeIsOnMaxPos();
    }

}
