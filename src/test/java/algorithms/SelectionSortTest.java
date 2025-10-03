package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    private SelectionSort createSorter() {
        return new SelectionSort(new PerformanceTracker());
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        createSorter().sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        createSorter().sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        createSorter().sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        createSorter().sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {4, 2, 2, 5, 3};
        createSorter().sort(arr);
        assertArrayEquals(new int[]{2, 2, 3, 4, 5}, arr);
    }

    @Test
    void testWithNegativeNumbers() {
        int[] arr = {-3, -1, -7, 0, 2};
        createSorter().sort(arr);
        assertArrayEquals(new int[]{-7, -3, -1, 0, 2}, arr);
    }

    @Test
    void testLargeRandomArray() {
        Random random = new Random(42);
        int[] arr = random.ints(1000, -1000, 1000).toArray();
        int[] copy = Arrays.copyOf(arr, arr.length);

        createSorter().sort(arr);
        Arrays.sort(copy);

        assertArrayEquals(copy, arr);
    }

    @Test
    void testAlreadySortedStability() {
        // Selection sort is not stable by design,
        // but this test just ensures correctness
        int[] arr = {1, 1, 1, 1};
        createSorter().sort(arr);
        assertArrayEquals(new int[]{1, 1, 1, 1}, arr);
    }

    @Test
    void testNullArrayThrowsException() {
        SelectionSort sorter = createSorter();
        assertThrows(NullPointerException.class, () -> sorter.sort(null));
    }
}
