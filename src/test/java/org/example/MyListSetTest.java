package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class MyListSetTest {
    @Test
    public void addTest() {
        assertTrue(MyListSet.of(1).contains(1));
        assertFalse(MyListSet.of(1).contains(2));
        assertFalse(MyListSet.of().contains(1));
    }

    @Test
    public void removeTest() {
        assertFalse(MyListSet.of(1, 2, 3).remove(2).contains(2));
    }

    @Test
    public void isEmptyTest() {
        assertTrue(MyListSet.of().isEmpty());
        assertFalse(MyListSet.of(1, 2, 3).isEmpty());
        assertTrue(MyListSet.of(1).remove(1).isEmpty());
        assertFalse(MyListSet.of(1, 2, 3).remove(1).isEmpty());
        assertFalse(MyListSet.of(1).remove(2).isEmpty());
        assertTrue(MyListSet.of(1, 2).remove(1).remove(2).isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(0, MyListSet.of().size());
        assertEquals(1, MyListSet.of(1).size());
        assertEquals(3, MyListSet.of(1, 2, 3).size());
        assertEquals(MyListSet.of().size(), MyListSet
                .of(1, 2, 3).remove(1).remove(2).remove(3).size());
        assertEquals(1, MyListSet.of().add(1).add(1).size());
    }

    @Test
    public void equalsTest() {
        assertEquals(MyListSet.of(), MyListSet.of());
        assertEquals(MyListSet.of(1), MyListSet.of().add(1));
        assertNotEquals(MyListSet.of(1, 2, 3), MyListSet.of(4, 5, 6));
        assertNotEquals(MyListSet.of(1, 2, 3), MyListSet.of(1, 2, 3).remove(1));
        assertEquals(MyListSet.of(1, 2, 3)
                .remove(1).remove(2).remove(3), MyListSet.of());

        assertEquals(MyListSet.of(1, 2), MyListSet.of(2, 1));
        assertNotEquals(MyListSet.of(1, 2, 3), MyListSet.of(1, 2));
        assertNotEquals(MyListSet.of(1, 2), MyListSet.of(1, 2, 3));
    }

    @Test
    public void isSubsetOfTest() {
        assertTrue(MyListSet.of().isSubsetOf(MyListSet.of()));
        assertTrue(MyListSet.of().isSubsetOf(MyListSet.of(1, 2, 3)));

        assertTrue(MyListSet.of(1, 2).isSubsetOf(MyListSet.of(1, 2, 3)));
        assertFalse(MyListSet.of(1, 2, 3).isSubsetOf(MyListSet.of(1, 2)));
        assertFalse(MyListSet.of(1).isSubsetOf(MyListSet.of(2)));
    }

    @Test
    @Disabled
    public void toStringTest() {
        assertEquals("[ 1  2  3 ]", MyListSet.of(1, 2, 3).toString());


        // Make this happen
        for (int value : MyListSet.of(1, 2, 3)) {
            System.out.println(value);
        }

        Iterator<Integer> iterator = MyListSet.of(1, 2, 3).iterator();

        while (iterator.hasNext()){
            int value = iterator.next();
            System.out.println(value);
        }
    }
}
