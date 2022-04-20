package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {
    @Test
    public void addTest(){
        assertTrue(MySet.of(1).contains(1));
        assertFalse(MySet.of(1).contains(2));
        assertFalse(MySet.of().contains(1));
    }
}
