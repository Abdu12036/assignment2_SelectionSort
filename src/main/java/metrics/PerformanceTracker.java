package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long arrayAccesses;

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementArrayAccesses() {
        arrayAccesses++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public void exportToCSV(String filename, String algorithm, int n, long runtimeNs) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(String.format("%s,%d,%d,%d,%d,%d\n",
                    algorithm,
                    n,
                    runtimeNs,
                    comparisons,
                    swaps,
                    arrayAccesses));
        } catch (IOException e) {
            System.err.println("Error writing metrics to CSV: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "PerformanceTracker{" +
                "comparisons=" + comparisons +
                ", swaps=" + swaps +
                ", arrayAccesses=" + arrayAccesses +
                '}';
    }
}
