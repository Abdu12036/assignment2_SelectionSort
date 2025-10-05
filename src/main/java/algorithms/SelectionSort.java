package algorithms;

import metrics.PerformanceTracker;


public class SelectionSort {

    private final PerformanceTracker tracker;

    public SelectionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        tracker.reset();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            boolean swapped = false;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses();
                tracker.incrementArrayAccesses();

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    swapped = true;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }

            if (!swapped) {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses();
        tracker.incrementArrayAccesses();
        tracker.incrementArrayAccesses();
        tracker.incrementArrayAccesses();

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

