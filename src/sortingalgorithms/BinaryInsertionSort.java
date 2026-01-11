package sortingalgorithms;

public class BinaryInsertionSort {
    private static int counter = 0;

    private BinaryInsertionSort() {
    }

    public static void useBinaryInsertionSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        counter++;
        for (int i = left + 1; i <= right; i++) {
            counter++;
            counter++;

            counter++;
            int key = arr[i];

            // Optimization: Single check to skip already-sorted elements
            if (key >= arr[i - 1]) {
                counter++;
                continue;
            }

            counter++;
            int low = left;
            counter++;
            int high = i - 1;

            while (low <= high) {
                counter++;
                counter++;
                int mid = (low + high) >>> 1;
                if (key < arr[mid]) {
                    counter++;
                    high = mid - 1;
                } else {
                    counter++;
                    low = mid + 1;
                }
            }

            counter++;
            int nToMove = i - low;
            if (nToMove > 0) {
                counter++;
                System.arraycopy(arr, low, arr, low + 1, nToMove);
            }
            arr[low] = key;
        }
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}