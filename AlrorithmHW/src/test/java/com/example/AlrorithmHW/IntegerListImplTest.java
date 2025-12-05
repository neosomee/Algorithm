package com.example.AlrorithmHW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;

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


    @Test
    void growIfNeedExpandsStorage() {
        IntegerListImpl small = new IntegerListImpl(2);
        small.add(1);
        small.add(2);
        small.add(3);

        assertEquals(3, small.size());
        assertEquals(1, small.get(0));
        assertEquals(2, small.get(1));
        assertEquals(3, small.get(2));
    }

    @Test
    void sortInsertionSortWorks() {
        Integer[] arr = {5, 1, 4, 2, 8};
        list.sort(arr);
        assertArrayEquals(new Integer[]{1, 2, 4, 5, 8}, arr);
    }

    @Test
    void quickSortSortsArray() throws Exception {
        Integer[] arr = {5, 1, 4, 2, 8, 3};
        Method quickSort = IntegerListImpl.class
                .getDeclaredMethod("quickSort", Integer[].class, int.class, int.class);
        quickSort.setAccessible(true);
        quickSort.invoke(list, (Object) arr, 0, arr.length - 1);

        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 8}, arr);
    }

    @Test
    void partitionPlacesPivotCorrectly() throws Exception {
        Integer[] arr = {4, 3, 7, 1, 5};
        Method partition = IntegerListImpl.class
                .getDeclaredMethod("partition", Integer[].class, int.class, int.class);
        partition.setAccessible(true);
        int pivotIndex = (int) partition.invoke(list, (Object) arr, 0, arr.length - 1);

        Integer pivot = arr[pivotIndex];
        for (int i = 0; i < pivotIndex; i++) {
            assertTrue(arr[i] < pivot);
        }
        for (int i = pivotIndex + 1; i < arr.length; i++) {
            assertTrue(arr[i] >= pivot);
        }
    }

    @Test
    void swapElementsSwapsValues() throws Exception {
        Integer[] arr = {1, 2, 3};
        Method swap = IntegerListImpl.class
                .getDeclaredMethod("swapElements", Integer[].class, int.class, int.class);
        swap.setAccessible(true);
        swap.invoke(list, (Object) arr, 0, 2);

        assertArrayEquals(new Integer[]{3, 2, 1}, arr);
    }

    @Test
    void containsUsesSortedSearch() {
        list.add(5);
        list.add(1);
        list.add(3);

        assertTrue(list.contains(1));
        assertTrue(list.contains(3));
        assertFalse(list.contains(42));
    }
}
