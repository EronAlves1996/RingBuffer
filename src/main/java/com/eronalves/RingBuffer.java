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

    public T read(){
        return buffer.get(cursor.nextRead());
    }
}
