package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {
    @Test
    public void addTest() {
        assertTrue(MySet.of(1).contains(1));
        assertFalse(MySet.of(1).contains(2));
        assertFalse(MySet.of().contains(1));
    }

    @Test
    public void removeTest() {
        assertFalse(MySet.of(1, 2, 3).remove(2).contains(2));
    }

    @Test
    public void isEmptyTest() {
        assertTrue(MySet.of().isEmpty());
        assertFalse(MySet.of(1, 2, 3).isEmpty());
        assertTrue(MySet.of(1).remove(1).isEmpty());
        assertFalse(MySet.of(1, 2, 3).remove(1).isEmpty());
        assertFalse(MySet.of(1).remove(2).isEmpty());
        assertTrue(MySet.of(1, 2).remove(1).remove(2).isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, MySet.of().size());
        assertEquals(1, MySet.of(1).size());
        assertEquals(3, MySet.of(1, 2, 3).size());
        assertEquals(MySet.of().size(), MySet
                .of(1, 2, 3).remove(1).remove(2).remove(3).size());
        assertEquals(1, MySet.of().add(1).add(1).size());
    }

    @Test
    public void equalsTest() {
        assertEquals(MySet.of(), MySet.of());
        assertEquals(MySet.of(1), MySet.of().add(1));
        assertNotEquals(MySet.of(1, 2, 3), MySet.of(4, 5, 6));
        assertNotEquals(MySet.of(1, 2, 3), MySet.of(1, 2, 3).remove(1));
        assertEquals(MySet.of(1, 2, 3)
                .remove(1).remove(2).remove(3), MySet.of());

        assertEquals(MySet.of(1, 2), MySet.of(2, 1));
        assertNotEquals(MySet.of(1, 2, 3), MySet.of(1, 2));
        assertNotEquals(MySet.of(1, 2), MySet.of(1, 2, 3));
    }

    @Test
    public void isSubsetOfTest() {
        assertTrue(MySet.of().isSubsetOf(MySet.of()));
        assertTrue(MySet.of().isSubsetOf(MySet.of(1, 2, 3)));

        assertTrue(MySet.of(1, 2).isSubsetOf(MySet.of(1, 2, 3)));
        assertFalse(MySet.of(1, 2, 3).isSubsetOf(MySet.of(1, 2)));
        assertFalse(MySet.of(1).isSubsetOf(MySet.of(2)));
    }

    @Test
    public void toStringTest() {
        assertEquals("[ 1  2  3 ]", MySet.of(1, 2, 3).toString());

    }
}
