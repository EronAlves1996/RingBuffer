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
}
