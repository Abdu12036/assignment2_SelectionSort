# Assignment 2. Design and Analysis of Algorithms
# Pair 1. Selection Sort Implementation (Student B)

The goal is to:
- Implement and optimize Selection Sort with **early termination**.
- Measure **comparisons, swaps, array accesses, runtime**.
- Validate **complexity analysis** both theoretically and empirically.


## Repository Structure

assignment2-selection-sort/
├── src/main/java/
│ ├── algorithms/SelectionSort.java
│ ├── metrics/PerformanceTracker.java
│ └── cli/BenchmarkRunner.java
├── src/test/java/
│ └── algorithms/SelectionSortTest.java
├── docs/
│ ├── analysis-report.pdf
│ └── performance-plots/
├── README.md
└── pom.xml

## Basic Idea
Selection Sort repeatedly selects the smallest element from the unsorted portion of the array and places it at the beginning.
for i = 0 to n - 2
minIndex = i
for j = i + 1 to n - 1
if arr[j] < arr[minIndex]
minIndex = j
if minIndex != i
swap(arr[i], arr[minIndex])

## Complexity Analysis
| Case            | Comparisons          | Swaps | Time Complexity | Notes                |
| --------------- | -------------------- | ----- | --------------- | -------------------- |
| **Best (Ω)**    | O(n) with early stop | O(1)  | Ω(n)            | Array already sorted |
| **Average (Θ)** | ~n²/2                | O(n)  | Θ(n²)           | Random input         |
| **Worst (O)**   | ~n²/2                | O(n)  | O(n²)           | Reverse-sorted       |

## Theoretical Analysis Summary
| Aspect                 | Description                       |
| ---------------------- | --------------------------------- |
| **Growth rate**        | Quadratic in `n`                  |
| **Dominant term**      | n²                                |
| **Best case behavior** | Detects sorted input, exits early |
| **Worst case**         | Full quadratic comparisons        |
| **Auxiliary space**    | Constant                          |

## Performance Tracking
The implementation integrates a PerformanceTracker to collect:
Comparisons – number of arr[j] < arr[minIndex] checks
Swaps – how many element swaps occurred
Array Accesses – reads/writes during sorting
Runtime – execution time in nanoseconds
Metrics are printed to the console for each benchmark run.

## Testing
Unit tests ensure correctness across edge cases:

Test Case	Description
✅ Empty array	Returns empty
✅ Single element	Unchanged
✅ Already sorted	Early termination
✅ Reverse sorted	Maximum comparisons
✅ Duplicates	Correctly sorted
✅ Negative numbers	Correctly sorted
✅ Random array	Matches Arrays.sort()
✅ Null input	Throws IllegalArgumentException

## Key Insights
Selection Sort’s performance is dominated by comparison cost, not swaps.
Early termination improves real performance on nearly sorted data but does not change Θ(n²) asymptotic behavior.
Practical use is limited, but it’s valuable for understanding algorithmic efficiency and complexity reasoning.