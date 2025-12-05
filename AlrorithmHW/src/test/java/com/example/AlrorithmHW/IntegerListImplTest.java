package com.example.AlrorithmHW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IntegerListImplTest {

    private IntegerListImpl list;

    @BeforeEach
    void setUp() {
        list = new IntegerListImpl();
    }

    @Test
    void addItemIncreasesSize() {
        Integer result = list.add(42);
        assertEquals(1, list.size());
        assertEquals(42, result);
        assertEquals(42, list.get(0));
    }

    @Test
    void addAtIndexShiftsElements() {
        list.add(1);
        Integer result = list.add(0, 42);
        assertEquals(2, list.size());
        assertEquals(42, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    void removeShiftsElements() {
        list.add(1);
        list.add(2);
        Integer result = list.remove(0);
        assertEquals(1, list.size());
        assertEquals(2, list.get(0));
        assertEquals(1, result);
    }

    @Test
    void indexOfAndContainsWork() {
        list.add(42);
        assertTrue(list.contains(42));
        assertEquals(0, list.indexOf(42));
        assertEquals(-1, list.indexOf(100));
    }

    @Test
    void equalsComparesContent() {
        list.add(42);
        IntegerListImpl other = new IntegerListImpl();
        other.add(42);
        assertTrue(list.equals(other));
    }

    @Test
    void sizeIsEmptyClearWork() {
        assertTrue(list.isEmpty());
        list.add(42);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
    }
}
