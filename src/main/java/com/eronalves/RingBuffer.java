package com.eronalves;

import java.util.ArrayList;
import java.util.List;

public class RingBuffer<T> {

    private final List<T> buffer;
    private final Cursor cursor;

    public RingBuffer(int allocationSize){
        buffer = new ArrayList<>(allocationSize);
        cursor = Cursor.initialize(allocationSize);
    }

    public void insert(T element){
        buffer.add(cursor.nextWrite(), element);
    }

    public void insertWithoutRewrite(T element){
        if(isFull()) throw new RuntimeException("Buffer is Full");
        insertOrRewrite(element);
    }

    public T read(){
        if(isEmpty()) return null;
        return buffer.get(cursor.nextRead());
    }

    public boolean isEmpty(){
        return cursor.writeIsBehindRead();
    }

    public boolean isFull(){
        return cursor.readIsOnMaxPos();
    }

}
