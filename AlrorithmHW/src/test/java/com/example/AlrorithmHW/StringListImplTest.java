package com.example.AlrorithmHW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StringListImplTest {

    private StringListImpl list;

    @BeforeEach
    void setUp() {
        list = new StringListImpl();
    }

    @Test
    void addItemIncreasesSize() {
        String result = list.add("test");
        assertEquals(1, list.size());
        assertEquals("test", result);
        assertEquals("test", list.get(0));
    }

    @Test
    void addAtIndexShiftsElements() {
        list.add("first");
        String result = list.add(0, "new");
        assertEquals(2, list.size());
        assertEquals("new", list.get(0));
        assertEquals("first", list.get(1));
    }

    @Test
    void removeShiftsElements() {
        list.add("first");
        list.add("second");
        String result = list.remove(0);
        assertEquals(1, list.size());
        assertEquals("second", list.get(0));
        assertEquals("first", result);
    }

    @Test
    void indexOfAndContainsWork() {
        list.add("test");
        assertTrue(list.contains("test"));
        assertEquals(0, list.indexOf("test"));
        assertEquals(-1, list.indexOf("notest"));
    }

    @Test
    void equalsComparesContent() {
        list.add("test");
        StringListImpl other = new StringListImpl();
        other.add("test");
        assertTrue(list.equals(other));
    }

    @Test
    void sizeIsEmptyClearWork() {
        assertTrue(list.isEmpty());
        list.add("test");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void exceptionsAreThrown() {
        assertThrows(NullItemException.class, () -> list.add(null));

        list.add("test");
        assertThrows(InvalideIndexException.class, () -> list.get(2)); // 2 > size=1

        StringListImpl full = new StringListImpl(1);
        full.add("first");
        assertThrows(StorageFullException.class, () -> full.add("second"));
    }
}
