package sortingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimSort {

    static final int MIN_RUN = 32;
    private static int counter = 0;

    private TimSort() {
    }

    // Calculate minimum run length (kept small here for demo)
    static int calcMinRun(int n) {
        counter++;
        int r = 0;

        while (n >= MIN_RUN) {
            counter++;

            counter++;
            r |= (n & 1);
            counter++;
            n >>= 1;
        }

        counter++;
        return n + r;
    }

    // Insertion sort for small ranges
    public static void insertionSort(int[] arr, int left, int right) {
        counter++;
        for (int i = left + 1; i <= right; i++) {
            counter++;
            counter++;

            counter++;
            int key = arr[i];
            counter++;
            int j = i - 1;

            while (j >= left && arr[j] > key) {
                counter++;

                counter++;
                arr[j + 1] = arr[j];
                counter++;
                j--;
            }

            counter++;
            arr[j + 1] = key;
        }
        counter++;
    }

    // Merge two sorted subarrays [l..m] and [m+1..r]
    public static void merge(int[] arr, int l, int m, int r) {
        counter++;
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        counter++;
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        counter++;
        int i = 0;
        counter++;
        int j = 0;
        counter++;
        int k = l;

        while (i < left.length && j < right.length) {
            counter++;

            if (left[i] <= right[j]) {
                counter++;
                arr[k++] = left[i++];
            } else {
                counter++;
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            counter++;

            counter++;
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            counter++;

            counter++;
            arr[k++] = right[j++];
        }
    }

    // Detect ascending/descending run starting at index "start"
    static int findRun(int[] arr, int start, int n) {
        counter++;
        int end = start + 1;
        counter++;
        if (end == n) return end;

        // Determine direction
        if (arr[end] < arr[start]) {
            // descending
            while (end < n && arr[end] < arr[end - 1]) {
                counter++;

                counter++;
                end++;
            }
            reverse(arr, start, end - 1);
        } else {
            // ascending
            while (end < n && arr[end] >= arr[end - 1]) {
                counter++;

                counter++;
                end++;
            }
        }
        return end;
    }

    // Reverse subarray from l to r
    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            counter++;

            counter++;
            int temp = arr[l];
            counter++;
            arr[l] = arr[r];
            counter++;
            arr[r] = temp;
            counter++;
            l++;
            counter++;
            r--;
        }
    }

    // Timsort main function
    public static void useMinimalTimSort(int[] arr) {
        counter++;
        int n = arr.length;
        counter++;
        int minRun = calcMinRun(n);
        counter++;
        List<int[]> runs = new ArrayList<>();

        counter++;
        int i = 0;

        while (i < n) {
            counter++;

            counter++;
            int runEnd = findRun(arr, i, n);
            counter++;
            int runLen = runEnd - i;

            // Extend short runs to minRun using insertion sort
            if (runLen < minRun) {
                counter++;
                int end = Math.min(i + minRun, n);
                insertionSort(arr, i, end - 1);
                counter++;
                runEnd = end;
            }
            runs.add(new int[]{i, runEnd});
            i = runEnd;

            // Maintain merge balance
            while (runs.size() > 1) {
                counter++;

                counter++;
                int[] run1 = runs.get(runs.size() - 2);
                counter++;
                int[] run2 = runs.getLast();

                counter++;
                int l1 = run1[0];
                counter++;
                int r1 = run1[1];
                counter++;
                int l2 = run2[0];
                counter++;
                int r2 = run2[1];
                counter++;
                int len1 = r1 - l1;
                counter++;
                int len2 = r2 - l2;

                if (len1 <= len2) {
                    merge(arr, l1, r1 - 1, r2 - 1);
                    counter++;
                    runs.removeLast();
                    counter++;
                    runs.set(runs.size() - 1, new int[]{l1, r2});
                } else break;
            }
        }

        // Merge remaining runs
        while (runs.size() > 1) {
            counter++;
            int[] run1 = runs.get(runs.size() - 2);
            counter++;
            int[] run2 = runs.getLast();

            counter++;
            int l1 = run1[0];
            counter++;
            int r1 = run1[1];
            counter++;
            int r2 = run2[1];
            merge(arr, l1, r1 - 1, r2 - 1);
            counter++;
            runs.removeLast();
            counter++;
            runs.set(runs.size() - 1, new int[]{l1, r2});
        }
    }

    public static int getCounter() {
        return counter;
    }
}
