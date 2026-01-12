package sortingalgorithms;

public class WaveInsertionSort {
    private static int counter = 0;

    private WaveInsertionSort() {
    }

    public static void useWaveInsertionSort(int[] arr) {
        counter++;
        int n = arr.length;
        counter++;
        for (int i = 0; i < n - 1; i++) {
            counter++;
            counter++;
            if (((i % 2 == 0) && (arr[i] > arr[i + 1])) || ((i % 2 != 0) && (arr[i] < arr[i + 1]))) {
                swap(arr, i, i + 1);
            }
        }
        counter++;

        counter++;
        for (int i = 1; i < n; i++) {
            counter++;
            counter++;
            counter++;
            int key = arr[i];

            if (key >= arr[i - 1]) {
                counter++;
                continue;
            }

            counter++;
            int low = 0;
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
            counter++;
        }
        counter++;
    }

    private static void swap(int[] arr, int i, int j) {
        counter++;
        int temp = arr[i];
        counter++;
        arr[i] = arr[j];
        counter++;
        arr[j] = temp;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}