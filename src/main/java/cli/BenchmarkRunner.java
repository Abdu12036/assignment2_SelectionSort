package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class BenchmarkRunner {

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Selection Sort Benchmark Runner ===");
        System.out.print("Enter input size (e.g. 1000): ");
        int n = scanner.nextInt();

        System.out.print("Choose input type [1=random, 2=sorted, 3=reverse, 4=nearly-sorted]: ");
        int choice = scanner.nextInt();

        int[] arr = generateArray(n, choice);

        PerformanceTracker tracker = new PerformanceTracker();
        SelectionSort sorter = new SelectionSort(tracker);

        long start = System.nanoTime();
        sorter.sort(arr);
        long end = System.nanoTime();

        long runtime = end - start;

        System.out.println("\n--- Results ---");
        System.out.println("Input size: " + n);
        System.out.println("Runtime (ns): " + runtime);
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
        System.out.println("Array accesses: " + tracker.getArrayAccesses());

        tracker.exportToCSV("selectionsort_results.csv", "SelectionSort", n, runtime);

        System.out.println("\nMetrics exported to selectionsort_results.csv");
    }

    private static int[] generateArray(int n, int choice) {
        int[] arr = new int[n];

        switch (choice) {
            case 1: // Random
                for (int i = 0; i < n; i++) {
                    arr[i] = random.nextInt(100000);
                }
                break;
            case 2: // Already sorted
                for (int i = 0; i < n; i++) {
                    arr[i] = i;
                }
                break;
            case 3: // Reverse sorted
                for (int i = 0; i < n; i++) {
                    arr[i] = n - i;
                }
                break;
            case 4: // Nearly sorted (90% sorted, 10% random noise)
                for (int i = 0; i < n; i++) {
                    arr[i] = i;
                }
                for (int i = 0; i < n / 10; i++) {
                    int idx1 = random.nextInt(n);
                    int idx2 = random.nextInt(n);
                    int temp = arr[idx1];
                    arr[idx1] = arr[idx2];
                    arr[idx2] = temp;
                }
                break;
            default:
                Arrays.fill(arr, 0);
                break;
        }

        return arr;
    }
}
