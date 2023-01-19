package com.eronalves;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRingBuffer {

    RingBuffer<String> stringRingBuffer;
    @BeforeEach
    void setStringRingBuffer(){
        stringRingBuffer = new RingBuffer<>(2);
    }

    @BeforeEach
    void populateValuesOnStringRingBuffer(){
        stringRingBuffer.insertOrRewrite("Ana"); // pos 0
        stringRingBuffer.insertOrRewrite("João"); // pos 1
    }

    @Test
    void testCreateBufferWithTwoSlots(){
        stringRingBuffer.insertOrRewrite("Ana");
        stringRingBuffer.insertOrRewrite("José");

        assertTrue(stringRingBuffer.isFull());
    }

    @Test
    void testCreateBufferAndIsEmpty(){
        RingBuffer<String> stringRingBuffer1 = new RingBuffer<>(2);

        assertTrue(stringRingBuffer1.isEmpty());
    }

    @Test
    void testRewrite(){
        stringRingBuffer.insertOrRewrite("Maria");

        assertEquals("Maria", stringRingBuffer.read());
    }

    @Test
    void testWriteWithoutRewrite(){
        assertThrows(RuntimeException.class,
                ()->stringRingBuffer.insertWithoutRewrite("Maria"));
        assertEquals("Ana", stringRingBuffer.read());
    }

    @Test
    void testWithoutRewriteAndInsertOne(){
        stringRingBuffer.read();
        stringRingBuffer.insertWithoutRewrite("Janio");
        stringRingBuffer.read();

        assertEquals("Janio" ,stringRingBuffer.read());
    }

    @Test
    void testRemovingAllElementsFromBuffer(){
        stringRingBuffer.read();
        stringRingBuffer.read();

        assertTrue(stringRingBuffer.isEmpty());
    }

}
