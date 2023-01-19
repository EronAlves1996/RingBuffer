package com.eronalves;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRingBuffer {

    @Test
    void testCreateBufferWithTwoSlots(){
        RingBuffer<String> stringRingBuffer = new RingBuffer<>(2);

        stringRingBuffer.insertOrRewrite("Ana");
        stringRingBuffer.insertOrRewrite("José");

        assertTrue(stringRingBuffer.isFull());
    }

}
